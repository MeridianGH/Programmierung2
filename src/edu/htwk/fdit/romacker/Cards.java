package edu.htwk.fdit.romacker;

import java.util.*;

enum Symbol {
  SEVEN("7"),
  EIGHT("8"),
  NINE ("9"),
  TEN  ("10"),
  JACK ("J"),
  QUEEN("Q"),
  KING ("K"),
  ACE  ("A");

  final String symbol;

  Symbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }
}

enum Color {
  CLUB   ("♧"),
  SPADE  ("♤"),
  HEART  ("♡"),
  DIAMOND("♢");

  final String color;

  Color(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}

enum Card {
  KREUZ_SIEBEN(Color.CLUB   , Symbol.SEVEN),
  KREUZ_ACHT  (Color.CLUB   , Symbol.EIGHT),
  KREUZ_NEUN  (Color.CLUB   , Symbol.NINE ),
  KREUZ_ZEHN  (Color.CLUB   , Symbol.TEN  ),
  KREUZ_BUBE  (Color.CLUB   , Symbol.JACK ),
  KREUZ_DAME  (Color.CLUB   , Symbol.QUEEN),
  KREUZ_KOENIG(Color.CLUB   , Symbol.KING ),
  KREUZ_ASS   (Color.CLUB   , Symbol.ACE  ),
  PIK_SIEBEN  (Color.SPADE  , Symbol.SEVEN),
  PIK_ACHT    (Color.SPADE  , Symbol.EIGHT),
  PIK_NEUN    (Color.SPADE  , Symbol.NINE ),
  PIK_ZEHN    (Color.SPADE  , Symbol.TEN  ),
  PIK_BUBE    (Color.SPADE  , Symbol.JACK ),
  PIK_DAME    (Color.SPADE  , Symbol.QUEEN),
  PIK_KOENIG  (Color.SPADE  , Symbol.KING ),
  PIK_ASS     (Color.SPADE  , Symbol.ACE  ),
  HERZ_SIEBEN (Color.HEART  , Symbol.SEVEN),
  HERZ_ACHT   (Color.HEART  , Symbol.EIGHT),
  HERZ_NEUN   (Color.HEART  , Symbol.NINE ),
  HERZ_ZEHN   (Color.HEART  , Symbol.TEN  ),
  HERZ_BUBE   (Color.HEART  , Symbol.JACK ),
  HERZ_DAME   (Color.HEART  , Symbol.QUEEN),
  HERZ_KOENIG (Color.HEART  , Symbol.KING ),
  HERZ_ASS    (Color.HEART  , Symbol.ACE  ),
  KARO_SIEBEN (Color.DIAMOND, Symbol.SEVEN),
  KARO_ACHT   (Color.DIAMOND, Symbol.EIGHT),
  KARO_NEUN   (Color.DIAMOND, Symbol.NINE ),
  KARO_ZEHN   (Color.DIAMOND, Symbol.TEN  ),
  KARO_BUBE   (Color.DIAMOND, Symbol.JACK ),
  KARO_DAME   (Color.DIAMOND, Symbol.QUEEN),
  KARO_KOENIG (Color.DIAMOND, Symbol.KING ),
  KARO_ASS    (Color.DIAMOND, Symbol.ACE  );

  final Color  color;
  final Symbol symbol;

  Card(Color color, Symbol symbol) {
    this.color = color;
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return color + String.valueOf(symbol);
  }
}

record Move(Card card, Color color) {}

interface MauMauable {
  void putOnTop(Card c);
  public int getPenalty();
  boolean isNotAllowed(Card c);
  void apply(Move m);
  Card top();
}

class MauMau implements MauMauable {
  Card top;

  @Override
  public void putOnTop(Card c) {
    top = c;
  }

  @Override
  public int getPenalty() {
    return 1;
  }

  @Override
  public boolean isNotAllowed(Card c) {
    return top.symbol != c.symbol && top.color != c.color;
  }

  @Override
  public void apply(Move m) {
    if(isNotAllowed(m.card())) {
      throw new RuntimeException("Player unallowed card, nothing is done.");
    }
    putOnTop(m.card());
    System.out.println("played: " + m.card());
  }

  @Override
  public Card top() {
    return top;
  }

  @Override
  public String toString() {
    return "# top-card: " + top;
  }

}

class MauMauExt extends MauMau {
  Color color;
  int penalty = 0;
  boolean skip = false;

  @Override
  public void putOnTop(Card c) {
    top = c;
    color = c.color;
  }

  @Override
  public int getPenalty() {
    int pen = 1;
    if (penalty > 0) {
      pen = penalty;
      penalty = 0;
    }
    skip = false; // getPenalty is only called once someone draws, so when one player isn't able to continue skipping.
    return pen;
  }

  @Override
  public boolean isNotAllowed(Card c) {
    // Player must draw when penalty is active and doesn't have seven.
    if (penalty > 0 && c.symbol != Symbol.SEVEN) { return true; }
    // Jack can't be played on Jack because (I quote) "Jack on Jack smells".
    if (c.symbol == Symbol.JACK && top.symbol == Symbol.JACK) { return true; }
    // If skipping (i.e. Ace has been played), only another Ace may be played or draw.
    if (skip && top.symbol == Symbol.ACE && c.symbol != Symbol.ACE) { return true; }
    // If symbols and colors don't match, draw.
    if (top.symbol != c.symbol && color != c.color) { return true; }
    // If every check fails, card may be played.
    return false;
  }

  @Override
  public void apply(Move m) {
    if(isNotAllowed(m.card())) {
      throw new RuntimeException("Player unallowed card, nothing is done.");
    }
    putOnTop(m.card());
    System.out.println("played: " + m.card());
    if (top.symbol == Symbol.SEVEN) {
      penalty += 2;
    }
    if (top.symbol == Symbol.ACE) {
      skip = true;
    }
    if (m.color() != null) {
      color = m.color();
      System.out.println("current color: " + m.color());
    }
  }
}


class Game {
  MauMauable state;
  LinkedList<Card> talon;
  Player[] players;
  Player winner;

  Game(Player[] players, MauMauable state) {
    this.players = players;
    talon = new LinkedList<Card>(Arrays.asList(Card.values()));
    Collections.shuffle(talon);

    // int cards_per_player = 5;
    this.state = state;
    state.putOnTop(talon.pop());
    for( Player p : players ) {
      p.setHand(talon.subList(0, 5).toArray(new Card[0]));
      talon.subList(0, 5).clear();
    }
    winner = null;
  }

  void start() {
    System.out.println("New game starts:");
    while( winner == null ) {
      for( Player p : players ) {
        System.out.println(p.getName() + " make your choice: ");
        Move m = p.ask(state);
        if( m.card() == null ) {
          int draws = state.getPenalty();
          System.out.println(p.getName() + " draws " + draws);
          for(int i = 0; i < draws; ++i) {
            if( !talon.isEmpty() ) {
              p.add(talon.pop());
            }
          }
          continue;
        }
        if( p.remove(m.card()) == 0 ) {
          winner = p;
          return;
        }
        talon.push(state.top());
        Collections.shuffle(talon);
        state.apply(m);
      }
    }
  }
}

class Player {
  String name;
  LinkedList<Card> hand;
  Player(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  void setHand(Card... crds) {
    hand = new LinkedList<Card>(Arrays.asList(crds));
    Collections.sort(hand);
  }

  public String toString() {
    return name + ": " + hand;
  }

  Move ask(MauMauable state) {
    int card_num;
    do {
      System.out.println(state);
      System.out.println("you have the cards: " + hand);
      System.out.println("make your choice: 0.." + (hand.size() - 1) + " (-1 for draw): ");
      Scanner in = new Scanner(System.in);
      card_num = in.nextInt();
      if( card_num <= -1 || card_num >= hand.size() ) {
        return new Move(null, null);
      }
    } while(state.isNotAllowed(hand.get(card_num)));
    Card c = hand.get(card_num);
    return new Move(c, c.symbol == Symbol.JACK ? chooseColor() : null);
  }

  int remove(Card c) {
    hand.remove(c);
    return hand.size();
  }

  void add(Card c) {
    hand.push(c);
    Collections.sort(hand);
  }

  Color chooseColor() {
    int color_num;
    do {
      System.out.println("choose a color: 0.." + (Color.values().length - 1) + " -> ♧, ♤, ♡, ♢ : ");
      Scanner in = new Scanner(System.in);
      color_num = in.nextInt();
    } while( color_num < 0 || color_num >= Color.values().length );
    return Color.values()[color_num];
  }
}

class ComputerPlayer extends Player {
  ComputerPlayer(String name) {
    super(name);
  }

  Move ask(MauMauable state) {
    System.out.println("Computer has the cards: " + hand);
    for (Card card : hand) {
      if (state.isNotAllowed(card)) { continue; }
      return new Move(card, card.symbol == Symbol.JACK ? chooseColor() : null);
    }
    return new Move(null, null);
  }

  @Override
  Color chooseColor() {
    Color bestColor = Color.values()[new Random().nextInt(4)];
    int highestCount = 0;
    for (int i = 0; i < hand.size(); i++) {
      int count = 0;
      Color color = hand.get(i).color;
      while (i < hand.size() && hand.get(i).color == color) { count++; i++; }
      if (count > highestCount) {
        highestCount = count;
        bestColor = color;
      }
    }
    return bestColor;
  }
}

public class Cards {
  public static void main(String[] args) {
    Game g = new Game(new Player[] {
      new Player("Human1"),
      new ComputerPlayer("Computer1")},
      new MauMauExt());
    g.start();
    System.out.println(g.winner.getName() + " has won.");
  }
}

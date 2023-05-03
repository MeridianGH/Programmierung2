package edu.htwk.fdit.romacker;

public class SimpleLinkedList {
    private Element head;
    private int size;

    public SimpleLinkedList(Object ...objs) {
        Element prev = null;
        for (int i = objs.length; i > 0; i--) {
            Element e = new Element(objs[i - 1]);
            e.next = prev;
            prev = e;
        }
        this.head = prev;
        this.size = objs.length;
    }

    public int size() {
        /* Count size using this code
        int size = 0;
        Element e = this.head;
        while (e.next != null) {
            e = e.next;
            size++;
        }*/
        return this.size;
    }

    private Element getElement(int index) {
        if (index < 0 || index > this.size() - 1) { return null; }
        Element e = this.head;
        for (int i = 0; i < index; i++) {
            if (e.next == null) { return null; }
            e = e.next;
        }
        return e;
    }

    public Object get(int index) {
        Element e = getElement(index);
        if (e == null) { return null; }
        return e.value;
    }

    public int findFirst(Object o) {
        int index = 0;
        Element e = this.head;
        while (e.value != o) {
            if (e.next == null) { return -1; }
            e = e.next;
            index++;
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        Element e = this.head;
        while (true) {
            if (e == null) {
                s.append("null]");
                break;
            }
            s.append(e).append(" -> ");
            e = e.next;
        }
        return s.toString();
    }

    public Object last() {
        return this.get(this.size() - 1);
    }

    public void append(Object o) {
        this.insert(o, this.size());
    }

    public void insert(Object o, int index) {
        if (index < 0 || index > this.size()) { return; }
        Element e = new Element(o);
        Element prev = this.getElement(index - 1);
        Element next = this.getElement(index);

        if (prev == null) {
            this.head = e;
        } else {
            prev.next = e;
        }
        e.next = next;

        this.size++;
    }

    public void delete(int index) {
        if (index < 0 || index > this.size() - 1) { return; }
        Element prev = this.getElement(index - 1);
        Element next = this.getElement(index + 1);

        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
        }

        this.size--;
    }

    private static class Element {
        Object value;
        Element next = null;

        Element(Object o) {
            this.value = o;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}

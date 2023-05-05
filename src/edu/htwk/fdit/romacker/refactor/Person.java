package edu.htwk.fdit.romacker.refactor;

import java.time.LocalDate;

public class Person {
        String name;
        String surname;
        LocalDate birthday;
        Address address;
        BankAccount bankAccount;

        public Person(String name, String surname, LocalDate birthday, Address address, BankAccount bankAccount) {
                this.name = name;
                this.surname = surname;
                this.birthday = birthday;
                this.address = address;
                this.bankAccount = bankAccount;
        }

        public Person(String name, String surname, int birthDay, int birthMonth, int birthYear, String street, String houseNumber, String zip, String city, String country, String iban, String bic) {
                this.name = name;
                this.surname = surname;
                this.birthday = LocalDate.of(birthYear, birthMonth, birthDay);
                this.address = new Address(street, houseNumber, zip, city, country);
                this.bankAccount = new BankAccount(iban, bic);
        }

        @Override
        public String toString() {
                String s = "| " + this.name + " " + this.surname + "\n";
                s += "| " + this.birthday + "\n";
                s += "| " + this.address + "\n";
                s += "| " + this.bankAccount + "\n|_____";
                return s;
        }
}


package edu.htwk.fdit.romacker.refactor;

public class BankAccount {
    private String iban;
    private String bic;

    public BankAccount(String iban, String bic) {
        this.iban = iban.replace(" ", "");
        this.bic = bic;
    }

    public String countryCode() {
        return this.iban.substring(0, 2);
    }

    public String checkDigits() {
        return this.iban.substring(2, 4);
    }

    public String bankCode() {
        return this.iban.substring(4, 12);
    }

    public String accountNumber() {
        return this.iban.substring(12);
    }

    @Override
    public String toString() {
        return "IBAN: " + this.iban + ", BIC: " + this.bic;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return this.bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}

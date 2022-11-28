package com.rasyadhanizam.maybankbackendassessment.customer;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String bank;
    private String name;
    private String email;
    private LocalDate dob;
    private String number;
    private String type;
    private Float balance;
    private String iban;


    public Customer() {
    }

    public Customer(Long id, String bank, String name, String email, LocalDate dob, String number, String type, Float balance, String iban) {
        this.id = id;
        this.bank = bank;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.iban = iban;
    }

    public Customer(String bank, String name, String email, LocalDate dob, String number, String type, Float balance, String iban) {
        this.bank = bank;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getiban() {
        return iban;
    }

    public void setiban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", iban='" + iban + '\'' +
                '}';
    }
}

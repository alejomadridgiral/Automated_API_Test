package pojo;

import com.github.javafaker.Faker;

public class BankDataPOJO {

    private String name;
    private String lastName;
    private String amount;
    private String accountNumber;
    private String transactionType;
    private String email;
    private String active;
    private String country;
    private String telephone;
    private String id;


//    public BankDataPOJO(){}

    public BankDataPOJO(String name, String lastName, String amount, String accountNumber, String transactionType, String email, String active, String country, String telephone, String id) {
        this.name = name;
        this.lastName = lastName;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
        this.id = id;
    }

    public BankDataPOJO(){

        Faker fake= new Faker();

        this.name = fake.name().name();
        this.lastName = fake.name().lastName();
        this.amount = fake.numerify("1000");
        this.accountNumber = fake.numerify("1000000");
        this.transactionType = fake.finance().iban();
        this.email = fake.internet().emailAddress();
        this.active = fake.toString();
        this.country = fake.country().name();
        this.telephone = fake.phoneNumber().phoneNumber();
        this.id = fake.idNumber().valid();

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEmail() {
        return email;
    }

    public String getActive() {
        return active;
    }

    public String getCountry() {
        return country;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setId(String id) {
        this.id = id;
    }
}

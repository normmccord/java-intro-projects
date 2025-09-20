/*
Norman McCord
Kennesaw State University
IS3920
Assignment 3
Control Statements
 */


public class Accounts {
    //Private attributes
    private String name; //customer name
    private String type; //account type
    private double balance; //balance

    //constructor
    public Accounts(String name, String type, double balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    // constructor; name only, checking, balance=0
    public Accounts(String name) {
        this.name = name;
        this.type = "Checking";
        this.balance = 0.0;
    }

    // Getters
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getBalance(){
        return balance;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    // add to balance
    public void addAmount(double amount) {
        balance += amount;
    }

    // withdraw from balance
    public void deductAmount(double withdrawalAmount) {
        if (withdrawalAmount > balance) {
            System.out.println("Insufficient Funds.");
        }
        else {
            balance -= withdrawalAmount;
        }
    }

    //display balance with name and type
    public void displayBalance() {
        System.out.printf("Account Name: %s%n", name);
        System.out.printf("Account Type: %s%n", type);
        System.out.printf("Account Balance: $%.2f%n", balance);
    }


}

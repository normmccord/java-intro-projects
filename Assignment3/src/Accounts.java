public class Accounts {
    //Private attributes
    private String name; //customer name
    private String type; //account type
    private double balance; //balance

    //overloaded constructor
    public Accounts(String name, String type, double balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
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


}

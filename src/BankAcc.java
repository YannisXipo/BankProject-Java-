import java.util.Scanner;

public class BankAcc {

    protected String Fname ;
    protected String Lname ;
    protected double Balance ;
    protected String AccNumber;


    public void SetFname(String Fname){
        this.Fname = Fname;
    }

    public void SetLname(String Lname){
        this.Lname = Lname;
    }

    public void SetAccNumber(String AccNumber){
        this.AccNumber = AccNumber;
    }

    public void SetBalance(Double balance){
        this.Balance = balance;
    }

    public String GetFname(){
        return Fname;
    }

    public String GetLname(){
        return Lname;
    }

    public String GetAccNumber(){
        return AccNumber;
    }

    public Double GetBalance(){
        return Balance;
    }


    public void Deposit(double input){
        this.Balance += input;
        System.out.println("Your new balance is "+ this.Balance);
    }

    public void Withdraw(double input){
        this.Balance -= input;
        System.out.println("Your new balance is "+ this.Balance);
    }
}

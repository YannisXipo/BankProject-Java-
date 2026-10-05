import java.util.ArrayList;
import java.util.Scanner;

public class Bank{
    ArrayList<BankAcc> accounts = new ArrayList<>();

    public void CreateAcc(String Fname, String Lname, String AccNumber, Double Balance){
        BankAcc acc = new BankAcc();
        acc.SetFname(Fname);
        acc.SetLname(Lname);
        acc.SetBalance(Balance);
        acc.SetAccNumber(AccNumber);
        accounts.add(acc);
    }

    public void ViewAcc(){
        BankAcc Acc = new BankAcc();
        Scanner in = new Scanner(System.in);
        String entry ;
        System.out.println("Please enter your account number");
        entry = in.nextLine();

        if(FindAccount(entry) == null){
            System.out.println("There is no account in our list that matches the account number you entered");
        }
        else{
            System.out.println("First Name: "+FindAccount(entry).GetFname());
            System.out.println("Last Name: "+FindAccount(entry).GetLname());
            System.out.println("Balance: "+FindAccount(entry).GetBalance());
            System.out.println("Account Number: "+FindAccount(entry).GetAccNumber());
        }
    }

    public BankAcc FindAccount(String AccNumber){ //this finds the account through the account number
        for(BankAcc acc : accounts){
            if(acc.GetAccNumber().equals(AccNumber)){
                return acc;
            }
        }
        return null;
    }

    public void ViewAll(){
        System.out.println("==============================");
        System.out.println("          ACCOUNTS       ");
        System.out.println("==============================");
        if(accounts.isEmpty()){
            System.out.println("There are no accounts to display");
        }
        else {
            for (BankAcc acc : accounts) {
                System.out.println("First Name: " + acc.GetFname());
                System.out.println("Last Name: " + acc.GetLname());
                System.out.println("Balance: " + acc.GetBalance());
                System.out.println("Account Number: " + acc.GetAccNumber());
            }
        }
    }

}



import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int dwVar = 1; //do while loop variable
        int line = 0;  //for the menu printing to create lines of =
        int f_loop = 0; //for loop variable
        Scanner choice = new Scanner(System.in); //scanner for the choice in the menu
        int ch ; //variable to save the choice
        Bank acc = new Bank();
        String AcNumber;

        do {
            for(line=0;line<2;line++) {
                for (f_loop = 1; f_loop <= 30; f_loop++) {
                    //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
                    // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
                    System.out.printf("=");


                }
                System.out.print(System.lineSeparator().repeat(2));
                if(line == 0)
                {
                    System.out.print("   BANK ACCOUNT MANAGEMENT");
                    System.out.print(System.lineSeparator().repeat(2));
                }
                if (line == 1) {
                    System.out.print(System.lineSeparator().repeat(1));
                    System.out.println("1. Create account");
                    System.out.println("2. View account");
                    System.out.println("3. Deposit money");
                    System.out.println("4. Withdraw money");
                    System.out.println("5. Transfer money");
                    System.out.println("6. View all accounts");
                    System.out.println("7. Delete account");
                    System.out.println("8. Exit\n");


                   do{
                       System.out.println("Please enter an integer 1-8 to access the menu");
                       if(choice.hasNextInt()){
                           ch = choice.nextInt();
                           if(ch > 0 && ch < 9){
                               break;
                           }
                           else{
                               System.out.println("Please try again\n");
                           }
                       }
                       else{
                           System.out.println("Please try again\n");
                           choice.nextLine();
                       }
                   }while(true);

                    switch (ch){ //to access menu

                        case 1:
                            case1L:
                            while(true){


                                System.out.println("Please enter your First Name");
                                System.out.println("This field must only contain letters");
                                System.out.println("Type 'EXIT' if you wish to go back to the menu at any time\n");

                                choice.nextLine(); //remove unwanted input
                                String Fname = choice.nextLine();

                                if (Fname.equalsIgnoreCase("EXIT")) {
                                    break case1L;
                                }


                                while (Fname.matches("[a-zA-Z]+") != true) {
                                    System.out.println("This field must only contain letters, try again");
                                    Fname = choice.nextLine();
                                    if (Fname.equalsIgnoreCase("EXIT")) {
                                        break case1L;
                                    }
                                }


                                System.out.println("Please enter your Last Name");
                                System.out.println("This field must only contain letters");
                                System.out.println("Type 'EXIT' if you wish to go back to the menu at any time\n");

                                String Lname = choice.nextLine();

                                if (Lname.equals("EXIT")) {
                                    break case1L;
                                }

                                while (Lname.matches("[a-zA-Z]+") != true) {
                                    System.out.println("This field must only contain letters, try again");
                                    Lname = choice.nextLine();
                                    if (Fname.equals("EXIT")) {
                                        break case1L;
                                    }
                                }
                                System.out.println("Your First and Last name have been updated successfully\n");

                                boolean VarWh = true;
                                int counter = 0;
                                String AccNum = null;
                                System.out.println("Please enter your personal account number");
                                System.out.println("The number must contain the letters GR at the start and 8 integers");
                                System.out.println("Please avoid using spaces between the letters and the numbers or the input will be invalid");
                                System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");


                                String numb = choice.nextLine(); //save the input here
                                if (numb.equalsIgnoreCase("EXIT")) {
                                    break case1L;
                                }

                                while (VarWh) {
                                    if (numb.length() == 10) { //we must first check if the input is the appropriate length
                                        if (numb.charAt(0) == 'G' && numb.charAt(1) == 'R') { //if it doesnt have GR reject it
                                            for (int i = 2; i < 10; i++) { //check every other entry to see if there are 8 integers
                                                if (!Character.isDigit(numb.charAt(i))) {
                                                    System.out.println("Please enter a valid entry");
                                                    numb = choice.nextLine();
                                                    counter = 0; //this counter is here to check the numbers one by one
                                                    if (numb.equalsIgnoreCase("EXIT")) {
                                                        break case1L;
                                                    }
                                                } else {
                                                    counter++;
                                                    if (counter == 8) {
                                                        if(acc.FindAccount(numb) == null){ // an if to check there is no other account with that same Personal Number
                                                            System.out.println("Your Account Number has been updated successfully\n");
                                                            VarWh = false;
                                                            AccNum = numb;
                                                            break;}//break for
                                                        else{
                                                            System.out.println("There is already an account with that personal number try entering a new one");
                                                            numb = choice.nextLine();
                                                            if (numb.equals("EXIT")) {
                                                                break case1L;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("Please enter a valid entry");
                                            numb = choice.nextLine();
                                            if (numb.equals("EXIT")) {
                                                break case1L;
                                            }
                                        }
                                    } else {
                                        System.out.println("Please enter a valid entry");
                                        numb = choice.nextLine();
                                        if (numb.equals("EXIT")) {
                                            break case1L;
                                        }
                                    }
                                }


                                System.out.println("Please enter your initial balance this number can not be negative and must not contain letters");
                                System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");

                                while(true) {
                                    String inp = choice.nextLine();

                                    if(inp.equalsIgnoreCase("EXIT")){ //ignore case for case sensitivity also we use this to go back to the menu
                                        break case1L;
                                    }

                                    try{
                                        double balance = Double.parseDouble(inp);

                                        if(balance > 0){
                                            System.out.println("Balance updated successfully");
                                            acc.CreateAcc(Fname, Lname, AccNum, balance);
                                            break;
                                        }
                                        else{
                                            System.out.println("Please enter a positive number");
                                        }


                                    }catch(NumberFormatException e){
                                        System.out.println("Please enter a valid entry");

                                    }
                                }
                                break case1L;
                            }
                            break;
                        case 2:
                            acc.ViewAcc();
                            break;
                        case 3:
                            choice.nextLine();
                            System.out.println("Please enter the Account Number for the account you wish to deposit");
                            System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");

                            AcNumber = choice.nextLine();

                            if(AcNumber.equalsIgnoreCase("EXIT")){

                                break;
                            }

                            if(acc.FindAccount(AcNumber) == null){
                                System.out.println("There is no account that matches that number");
                            }
                            else{
                            boolean DepLoop = true;
                            double dep = 0;
                            System.out.println("Please enter the amount you wish to deposit");
                            System.out.println("This number can not contain letters or be negative\n");


                            while(DepLoop){
                                if(!choice.hasNextDouble()){
                                    String cho = choice.next();
                                    if(cho.equalsIgnoreCase("EXIT")){
                                        break;
                                    }
                                    System.out.println("Please enter a number without using letters");
                                    choice.nextLine();
                                }
                                else {
                                    dep = choice.nextDouble();
                                    if (dep < 0) {
                                        System.out.println("Please enter a positive number");
                                        choice.nextLine();
                                    } else {
                                        acc.FindAccount(AcNumber).Deposit(dep);
                                        System.out.println("Your deposit has been successfull\n");
                                        break;
                                        }
                                    }
                                }
                            }
                            break;
                        case 4:
                            choice.nextLine(); //clear unwanted input in the scanner
                            System.out.println("Please enter the Account Number for the account you wish to withdraw");
                            System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");

                            AcNumber = choice.nextLine();

                            if(AcNumber.equalsIgnoreCase("EXIT")){
                                break;
                            }

                            if(acc.FindAccount(AcNumber) == null){
                                System.out.println("There is no account that matches that number");
                            }
                            else{
                                boolean WitLoop = true;
                                double wit =  0;
                                System.out.println("Please enter the amount you wish to withdraw");
                                System.out.println("This number can not contain letters or be negative\n");

                                while(WitLoop){
                                    if(!choice.hasNextDouble()){
                                        String cho = choice.next();
                                        if(cho.equalsIgnoreCase("EXIT")){
                                            break;
                                        }
                                        System.out.println("Please enter a number without using letters");
                                        choice.nextLine();
                                    }
                                    else {
                                        wit = choice.nextDouble();
                                        if (wit < 0) {
                                            System.out.println("Please enter a positive number");
                                            choice.nextLine();
                                        } else {
                                            if(acc.FindAccount(AcNumber).GetBalance() < wit ){
                                                System.out.println("Your Balance is not enough to withdraw that amount try again");
                                                choice.nextLine();
                                            }
                                            else{
                                            acc.FindAccount(AcNumber).Withdraw(wit);
                                            System.out.println("Your withdraw has been successfull\n");
                                            choice.nextLine(); //clear scanner before the next choice
                                            break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Please enter the Account Number you wish to transfer funds from");
                            System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");

                            choice.nextLine(); //clear unwanted input in the scanner
                            AcNumber = choice.nextLine();
                            double wit =  0;

                            if(AcNumber.equalsIgnoreCase("EXIT")){
                                break;
                            }

                            if(acc.FindAccount(AcNumber) == null){
                                System.out.println("There is no account that matches that number");
                            }
                            else{
                                boolean WitLoop = true;
                                System.out.println("Please enter the amount you wish to transfer");
                                System.out.println("This number can not contain letters or be negative\n");

                                while(WitLoop){
                                    if(!choice.hasNextDouble()){
                                        System.out.println("Please enter a number without using letters");
                                        choice.nextLine();
                                    }
                                    else {
                                        wit = choice.nextDouble();
                                        if (wit < 0) {
                                            System.out.println("Please enter a positive number");
                                            choice.nextLine();
                                        } else {
                                            if(acc.FindAccount(AcNumber).GetBalance() < wit ){
                                                System.out.println("Your Balance is not enough to withdraw that amount try again");
                                                choice.nextLine();
                                            }
                                            else{
                                                acc.FindAccount(AcNumber).Withdraw(wit);
                                                System.out.println("Your withdraw has been successfull\n");
                                                choice.nextLine(); //clear scanner before the next choice
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 6:
                            acc.ViewAll();
                            break;
                        case 7:
                            choice.nextLine();
                            System.out.println("Please enter the Account Number of the account you wish to delete");
                            System.out.println("Press 'EXIT' if you wish to go back to the menu at any time\n");
                            String delete = choice.nextLine();

                            if(delete.equalsIgnoreCase("EXIT")){
                                break;
                            }

                            while(true){
                                if(acc.FindAccount(delete) == null) {
                                    delete = null;
                                    System.out.println("There is no account  in our Bank that matches the number you entered");
                                    System.out.println("Please try again\n");
                                    delete = choice.nextLine();
                                    if(delete.equalsIgnoreCase("EXIT")){
                                        break;
                                    }
                                }
                                else{
                                    acc.DeleteAcc(acc.FindAccount(delete));
                                    break;
                                }
                            }

                            break;
                        case 8:
                            dwVar = 0;
                            break;
                    }

                }
            }

        }
        while (dwVar == 1);
    }
}
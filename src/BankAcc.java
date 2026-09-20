import java.util.Scanner;
import java.util.ArrayList;

public class BankAcc {

    protected String Fname ;
    protected String Lname ;
    protected double Balance ;
    protected String AccNumber;



    public void FnameCheck(){
        Scanner name = new Scanner(System.in);
        System.out.println("Please enter your First Name");
        System.out.println("This field must only contain letters\n");

        while(name.hasNext("[a-zA-Z]+") != true){
            System.out.println("This field must only contain letters, try again");
            name.next();
        }
            this.Fname = name.next(); //after check sets the name
            name.nextLine(); // clears the leftover newline

        System.out.println("Please enter your Last Name");
        System.out.println("This field must only contain letters\n");

        while(name.hasNext("[a-zA-Z]+") != true){
            System.out.println("This field must only contain letters, try again");
            name.next();
        }
            this.Lname = name.next();

        System.out.println("Welcome Mr "+this.Fname+" "+this.Lname);
        return;
    }

    public void AccANumberCheck(){
        Boolean VarWh = true;
        Scanner num = new Scanner(System.in);
        int counter = 0;
        System.out.println("Please enter your personal account number");
        System.out.println("The number must contain the letters GR at the start and 8 integers");
        System.out.println("Please avoid using spaces between the letters and the numbers or the input will be invalid");


        String numb = num.nextLine(); //save the input here


       while(VarWh){
            if(numb.length() == 10){ //we must first check if the input is the appropriate length
                    if(numb.charAt(0) == 'G' && numb.charAt(1) == 'R'){ //if it doesnt have GR reject it
                       for(int i=2;i<10;i++){ //check every other entry to see if there 8 integers
                           if(!Character.isDigit(numb.charAt(i))){
                               System.out.println("Please enter a valid entry");
                               numb = num.nextLine();
                               counter = 0;
                           }
                           else{
                               counter++;
                               if(counter == 8){
                                System.out.println("Your Account Number is "+numb);
                                VarWh = false;
                                 break;}
                           }
                       }

                    }
                    else{
                        System.out.println("Please enter a valid entry");
                        numb = num.nextLine();
                    }
            }
            else{
                System.out.println("Please enter a valid entry");
                numb = num.nextLine();
            }
       }


    }
}

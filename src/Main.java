

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int dwVar = 1; //do while loop variable
        int line = 0;  //for the menu printing to create lines of =
        int f_loop = 0; //for loop variable
        Scanner choice = new Scanner(System.in); //scanner for the choice in the menu
        int ch; //variable to save the choice

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
                    System.out.println("5. Exit");
                    while (!choice.hasNextInt()) {
                        System.out.println("Please enter an integer.");
                        choice.next(); // discard the invalid input
                    }

                   dwVar = 0;

                }
            }

        }
        while (dwVar == 1);
    }
}
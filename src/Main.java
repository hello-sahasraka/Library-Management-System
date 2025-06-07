import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        System.out.println("Welcome to Your Library Portal!");
        System.out.println("_______________________________________________________");//Main manu of the control panel of the LMS(Library Managment System)
        System.out.println("Enter 0 to Add a New Book.");
        System.out.println("Enter 1 to Update Book Details.");
        System.out.println("Enter 2 to Delete a Book.");
        System.out.println("Enter 3 to Search for a Book.");
        System.out.println("Enter 4 to Add a New Member.");
        System.out.println("Enter 5 to Record a Loan.");
        System.out.println("Enter 6 to Record a Return.");

        System.out.print("---> Enter:");
        int var = scanner.nextInt();
        operations(var); //Calling the operation method

        System.out.println("_______________________________________________________");
        System.out.println("Thanks for Using!");
    }

    void operations(int var) { //All the functions in the LMS are manage in here
        Admin a = new Admin();
        boolean continueOperation;

        switch (var) { // Used switch case to choose which function to run
            case 0:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.addNewBook();// Add a new book
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 1:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.updateBook();//Update an existing book detail
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 2:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.deleteBook();//Delete a existing book
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 3:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.searchBook();//Search an existing book
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 4:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.addNewMember();//Add a new member details
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 5:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.recordLoan();//Record a new loan
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            case 6:
                do {//Used do while loop to iterate the functions if user wants  use the same function again and again
                    a.recordReturn();//Record Return
                    continueOperation = promptContinueOperation();
                } while (continueOperation);
                break;
            default:
                System.out.println("Wrong Input!, Enter Again.");//Displays an error message if enter a wrong input
                break;
        }
    }

    boolean promptContinueOperation() {//
        int var1;
        do {
            System.out.println("Enter 7 to Continue."); //used do while loop to get only 7 or 8 as inputs to continue and Exit
            System.out.println("Enter 8 to Exit.");
            System.out.print("--->Enter:");
            var1 = scanner.nextInt();

            if (var1 == 8) {
                return false;
            } else if (var1 == 7) {
                return true;
            } else {
                System.out.println("Wrong Input!, Enter Again.");//Displays an error msg if enters a wrong input
            }
        } while (true);
    }
}

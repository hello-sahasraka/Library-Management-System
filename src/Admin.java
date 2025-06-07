import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Admin {

    String url = "jdbc:mysql://localhost:3306/library_manage_system";//Location to database
    String username = "root";
    String password = "";

    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //DateTimeFormatter class is used to format the date in "yyyy-MM-dd" format.

    public void recordLoan() {
        Loan l = new Loan();

        try {//Try with resources to handle database connection and prepared statement
            System.out.print("Enter book ID: ");
            l.setBookId(scanner.nextInt());//Get a book ID and assign that value to Book ID

            System.out.print("Enter member ID: ");
            l.setMemberId(scanner.nextInt());//Get a Member ID and assign that value to member ID

            scanner.nextLine();//Used to read a complete line of text from the input.

            System.out.print("Enter loan date (yyyy-MM-dd): ");
            String loanDateInput = scanner.nextLine();//Get the date as a String
            LocalDate localDate_1 = LocalDate.parse(loanDateInput, formatter);//Parse the input string into a LocalDate object using the specified formatter
            Date loanDate = Date.valueOf(localDate_1);//converts a LocalDate object to a java.sql.Date object.
            l.setLoanDate(loanDateInput);

            String sql = "INSERT INTO loans (book_id, member_id, loan_date) VALUES (?, ?, ?)";//SQl query to insert data in to loans table

            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement pStatement = con.prepareStatement(sql)) {

                pStatement.setInt(1, l.getBookId());//Set the parameters for the prepared statement
                pStatement.setInt(2, l.getMemberId());
                pStatement.setDate(3, loanDate);

                int rowsInserted = pStatement.executeUpdate();
                if (rowsInserted > 0) {//Check if the insertion was successful
                    System.out.println("Loan was recorded successfully!");//Displays a message when insertion was successful
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());//Handle SQL exceptions
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");//Handle invalid date format exceptions
        }
    }

    public void recordReturn() {
        try {
            Loan l = new Loan();//Create a object from loan class

            System.out.print("Enter book ID: ");//Get a book ID and assign that value to Book ID
            l.setBookId(scanner.nextInt());

            scanner.nextLine();//Used to read a complete line of text from the input.

            System.out.print("Enter return date (yyyy-MM-dd): ");
            String returnDateInput = scanner.nextLine();//Get the date as a String
            LocalDate localDate_2 = LocalDate.parse(returnDateInput, formatter);//Parse the input string into a LocalDate object using the specified formatter
            Date returnDate = Date.valueOf(localDate_2);//converts a LocalDate object to a java.sql.Date object.
            l.setReturnDate(returnDateInput);

            String sql = "UPDATE loans SET return_date = ? WHERE book_id = ?";//SQl query to update table

            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement pStatement = con.prepareStatement(sql)) {

                pStatement.setDate(1, returnDate);//Set the parameters for the prepared statement
                pStatement.setInt(2, l.getBookId());

                int rowsInserted = pStatement.executeUpdate();
                if (rowsInserted > 0) {//Check if the update was successful
                    System.out.println("Return+ was recorded successfully!");//Displays a message when update was successful
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());//Handle SQL exceptions
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");//Handle invalid date format exceptions
        }
    }

    public void addNewMember() {

        Member m = new Member();//Create a object from member class

        System.out.print("Enter name: ");//Get a name and assign that value to name
        m.setName(scanner.nextLine());

        System.out.print("Enter email: ");//Get a email and assign that value to email
        m.setEmail(scanner.nextLine());

        System.out.print("Enter phone: ");////Get a phone and assign that value to phone
        m.setPhone(scanner.nextLine());


        String sql = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";//SQl query to insert

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pStatement = con.prepareStatement(sql)) {

            pStatement.setString(1, m.getName());//Set the parameters for the prepared statement
            pStatement.setString(2, m.getEmail());
            pStatement.setString(3, m.getPhone());

            int rowsInserted = pStatement.executeUpdate();
            if (rowsInserted > 0) {//Check if the update was successful
                System.out.println("A new member was inserted successfully!");//Displays a message when insertion was successful
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Handle SQL exceptions
        }

    }

    public void addNewBook() {

        Book b = new Book();

        System.out.print("Enter title: ");
        b.setTitle(scanner.nextLine());

        System.out.print("Enter author: ");
        b.setAuthor(scanner.nextLine());

        System.out.print("Enter publisher: ");
        b.setPublisher(scanner.nextLine());

        System.out.print("Enter year published: ");
        b.setYearPublished(scanner.nextLine());

        String sql = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";//SQl query to inset data in to table

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pStatement = con.prepareStatement(sql)) {

            pStatement.setString(1, b.getTitle());//Set the parameters for the prepared statement
            pStatement.setString(2, b.getAuthor());
            pStatement.setString(3, b.getPublisher());
            pStatement.setString(4, b.getYearPublished());

            int rowsInserted = pStatement.executeUpdate();
            if (rowsInserted > 0) {//Check if the insertion was successful
                System.out.println(b.getTitle() + " inserted successfully!");//Displays a message when insertion was successful
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Handle SQL exceptions
        }
    }
    public void searchBook() {
        System.out.println("If you want to search,");//Control panel for to select attribute to search
        System.out.println("--->By title, Enter 1");
        System.out.println("--->By author, Enter 2");
        System.out.println("--->By year published, Enter 3");
        System.out.println("_____________________");
        System.out.print("--->Enter: ");
        int searchIndex = scanner.nextInt();
        String searchBy = "";

        switch (searchIndex) {//Used switch case to choose the attributes
            case 1:
                searchBy = "title";
                break;
            case 2:
                searchBy = "author";
                break;
            case 3:
                searchBy = "year_published";
                break;
            default:
                System.out.println("Invalid Input!");
                return;
        }

        scanner.nextLine();//Used to read a complete line of text from the input.

        System.out.print("Enter value: ");
        String value = scanner.nextLine();

        String sql = "SELECT * FROM books WHERE " + searchBy + " = ?";//SQL query to select data from a table

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pStatement = con.prepareStatement(sql)) {

            pStatement.setString(1, value);//Set the parameters for the prepared statement

            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {//Iterate through the result set
                    Book b = new Book();
                    b.setId(resultSet.getInt(1));//Set the book's properties from the result set
                    b.setTitle(resultSet.getString(2));
                    b.setAuthor(resultSet.getString(3));
                    b.setPublisher(resultSet.getString(4));
                    b.setYearPublished(resultSet.getString(5));

                    System.out.println("ID: " + b.getId() + ",  Title: " + b.getTitle() + ",    Author: " + b.getAuthor() + ",  Publisher: " + b.getPublisher() + ",    Year: " + b.getYearPublished());//Prints the search results
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());//Handle SQL exceptions
        }
    }


    public void deleteBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM books WHERE book_id = ?";//SQl query to delete a row in a table

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pStatement = con.prepareStatement(sql)) {

            pStatement.setInt(1, id);//Set the book's properties from the result set

            int rowsInserted = pStatement.executeUpdate();
            if (rowsInserted > 0) {//Check if the update was successful
                System.out.println("Book was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Handle SQL exceptions
        }
    }

    public void updateBook() {

        Book b = new Book();

        System.out.print("Enter book Id: ");
        int id = scanner.nextInt();

        System.out.println("If you want to update,");//Control panel for to select attribute to search
        System.out.println("--->Title, Enter 1");
        System.out.println("--->Author, Enter 2");
        System.out.println("--->Publisher, Enter 3");
        System.out.println("--->Year published, Enter 4");
        System.out.println("_____________________");
        System.out.print("--->Enter: ");
        int updateIndex = scanner.nextInt();
        String updateProperty = "";

        switch (updateIndex) {//Used switch case to choose the attributes
            case 1:
                updateProperty = "title";
                break;
            case 2:
                updateProperty = "author";
                break;
            case 3:
                updateProperty = "publisher";
                break;
            case 4:
                updateProperty = "year_published";
                break;
            default:
                System.out.println("Invalid Input!");
                return;
        }

        scanner.nextLine();

        System.out.print("Enter property value: ");
        String value = scanner.nextLine();

        String sql = "UPDATE books SET " + updateProperty + " = ? WHERE book_id = ?";//SQl query to update data in a table

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pStatement = con.prepareStatement(sql)) {

            pStatement.setString(1, value);//Set the book's properties from the result set
            pStatement.setInt(2, id);

            int rowsInserted = pStatement.executeUpdate();
            if (rowsInserted > 0) {//Check if the update was successful
                System.out.println(updateProperty + "updated successfully!");//Displays a message when update was successful
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Handle SQL exceptions
        }
    }
}

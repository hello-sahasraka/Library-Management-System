import java.sql.Date;

public class Loan {
    private int bookId;
    private int memberId;
    private String loanDate;
    private String returnDate;

    public int getBookId(){return bookId;}
    public int getMemberId(){return memberId;}
    public String getLoanDate(){return loanDate;}
    public String getReturnDate(){return returnDate;}

    public void setBookId(int bookId){this.bookId = bookId;}
    public void setMemberId(int memberId){this.memberId = memberId;}
    public void setLoanDate(String loanDate){this.loanDate = loanDate;}
    public void setReturnDate(String returnDate){this.returnDate = returnDate;}


}

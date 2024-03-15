package lk.ijse.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private int userId;
    private String userName;

    private String branchName;
    private int bookId;

    private String bookname;

    private LocalDateTime borrowed;
    private LocalDateTime returnedDate;
    private Boolean isReturn;

    public TransactionDto() {
    }

    public TransactionDto(int userId, String userName, String branchName, int bookId, String bookname, LocalDateTime borrowed, LocalDateTime returnedDate, Boolean isReturn) {
        this.userId = userId;
        this.userName = userName;
        this.branchName = branchName;
        this.bookId = bookId;
        this.bookname = bookname;
        this.borrowed = borrowed;
        this.returnedDate = returnedDate;
        this.isReturn = isReturn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public LocalDateTime getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(LocalDateTime borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Boolean getReturn() {
        return isReturn;
    }

    public void setReturn(Boolean aReturn) {
        isReturn = aReturn;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", bookId=" + bookId +
                ", bookname='" + bookname + '\'' +
                ", borrowed=" + borrowed +
                ", returnedDate=" + returnedDate +
                ", isReturn=" + isReturn +
                '}';
    }
}

package lk.ijse.dto;

public class UserDto {
    private String userId;
    private String userName;
    private String pw;
    private String email;

    public UserDto() {
    }

    public UserDto(String userName, String pw, String email) {
        this.userName = userName;
        this.pw = pw;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
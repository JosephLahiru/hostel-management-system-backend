package me.mtron.hostelmanagementsystembackend.models;

public class RegistrationDTO {
    private String registrationNum;
    private String username;
    private String email;
    private String password;

    public RegistrationDTO() {
        super();
    }

    public RegistrationDTO(String registrationNum, String username, String email, String password) {
        super();
        this.registrationNum = registrationNum;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registrationNum='" + registrationNum + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

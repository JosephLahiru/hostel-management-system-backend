package me.mtron.hostelmanagementsystembackend.payload.error;

public class ErrorMessage {
    private String message;
    private int status;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}

package Projects.Project2;

public class InvalidMapException extends Exception{
    private String message;

    InvalidMapException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
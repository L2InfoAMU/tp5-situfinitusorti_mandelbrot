package image;

public class NotSupportedException extends RuntimeException {
    String message;

    public NotSupportedException(String message){
        this.message = message;
    }

}

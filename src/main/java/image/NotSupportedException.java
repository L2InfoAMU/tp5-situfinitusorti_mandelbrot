package image;

public class NotSupportedException extends RuntimeException{
    String string;

    public NotSupportedException(String string){
        this.string = string;
    }

}

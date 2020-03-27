package hw12.Exceptions;

public class MinusAgeException extends RuntimeException {
    public MinusAgeException(){
        super("Age can't be minus");
    }
}

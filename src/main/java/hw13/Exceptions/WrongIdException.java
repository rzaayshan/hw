package hw13.Exceptions;

public class WrongIdException extends RuntimeException {
    public WrongIdException(){
        System.out.println("There isn't family with this id!");
    }
}

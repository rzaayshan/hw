package hw12.Exceptions;

public class FamilyOverflowException extends RuntimeException {
    public FamilyOverflowException(){
        super ("Number of family members is big!");
    }
}

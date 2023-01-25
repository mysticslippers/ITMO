package Exceptions;

public class DistanceOutOfRangeException extends ArithmeticException{

    public DistanceOutOfRangeException(){
        super("Они перебежали замок!");
    }
}

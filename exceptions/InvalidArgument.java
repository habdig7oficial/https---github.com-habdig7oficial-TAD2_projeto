package exceptions;

public class InvalidArgument extends RuntimeException {
    public InvalidArgument(short argsMin, short argsMax, int have){
        super(String.format("Expect BETWEEN %d and %d\nBut %d was given", argsMin, argsMax, have));
    }
}

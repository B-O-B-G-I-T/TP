package classe;

public class CapacityExceededException extends Exception {

    public CapacityExceededException(double depassement) {
        super("La capacité est dépassé de " + depassement);

    }
}
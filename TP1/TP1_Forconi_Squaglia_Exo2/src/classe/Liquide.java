package classe;

public enum Liquide {
    eau(10), 
    vin(15), 
    huile(9);

    public final int IDEAL_TEMP;

    Liquide(int temp) {
        this.IDEAL_TEMP = temp;
    }
}
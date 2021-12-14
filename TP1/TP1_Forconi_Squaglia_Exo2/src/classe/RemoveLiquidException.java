package classe;

public class RemoveLiquidException extends Exception {

	public RemoveLiquidException(double depassement) {
		super("Il y a pas assez de liquide il manque "+ depassement);
	}

}
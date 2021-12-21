package TP1_EXO2.classe;

public class RemoveLiquidException extends Exception {

	public RemoveLiquidException(double depassement) {
		super("Il y a pas assez de liquide il manque "+ depassement);
	}

}
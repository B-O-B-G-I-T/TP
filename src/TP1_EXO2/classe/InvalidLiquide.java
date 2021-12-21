package TP1_EXO2.classe;

public class InvalidLiquide extends Exception{

    public InvalidLiquide() {
		super("Liquide invalide utilisez la méthode nettoyage() d'abord");
	}
}

/**
 * Pair
 */
public class Pair <PREMIER, SECOND> {

    private PREMIER premierAttribut;
    private SECOND secondAttribut;

    Pair(PREMIER premierParametre, SECOND secondParametre){

        setPremierAttribut(premierParametre);
        setSecondAttribut(secondParametre);

    }

    public void setPremierAttribut(PREMIER premierAttribut) {
        this.premierAttribut = premierAttribut;
    }
    public void setSecondAttribut(SECOND secondAttribut) {
        this.secondAttribut = secondAttribut;
    }

    public PREMIER getPremierAttribut() {
        return premierAttribut;
    }

    public SECOND getSecondAttribut() {
        return secondAttribut;
    }

    
}
package classe;

public class CiterneSecurise extends Citerne{

    public Citerne CiterneDeTropPlein;

    public CiterneSecurise(int capacite, Liquide liquide, int capaciteTropPlein) throws MinCapacityExeception, MaxException {
        super(capacite, liquide);
        //TODO Auto-generated constructor stub

        if(capaciteTropPlein > 20000){
            capaciteTropPlein = capacite/10;
            throw new MaxException();
        }
        if(capaciteTropPlein < 0){
            capaciteTropPlein = capacite / 10;
            throw new MinCapacityExeception();
        }

        CiterneDeTropPlein = new Citerne(capaciteTropPlein, liquide);
    }

    public String toString() {
        return super.toString() + " capacite cuve de trop plein: " + CiterneDeTropPlein.capacite +
                ", volume cuve de trop plein: " + CiterneDeTropPlein.volume;
    }
    //@Override
    public boolean equals(Object obj){

        boolean check1 = false, check2 = false;

        if(obj != null && obj instanceof CiterneSecurise){
            CiterneSecurise citerneTempo = (CiterneSecurise)obj;
            check1 = super.equals(citerneTempo);
            check2 = citerneTempo.CiterneDeTropPlein.equals(this.CiterneDeTropPlein);
            
        }
        return(check1 && check2);
    }
    
}

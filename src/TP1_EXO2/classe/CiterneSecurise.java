package TP1_EXO2.classe;

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

    public void ajouterLiquide(Double quantiteAjoute, boolean enMetreCube, Liquide liquide) throws CapacityExceededException, InvalidLiquide{
        if (enMetreCube == true) {

            if (quantiteAjoute + volume > capacite) {
                volume = capacite;
                double futurVolume = quantiteAjoute - (capacite - volume);
                if( futurVolume < CiterneDeTropPlein.capacite){
                    CiterneDeTropPlein.volume = futurVolume;
                }
                else
                    CiterneDeTropPlein.volume = CiterneDeTropPlein.capacite;
                    throw new CapacityExceededException((quantiteAjoute - volume));
            }
            if (liquideCiterne == null) {
                liquideCiterne = liquide;
            } else if (liquideCiterne != liquide) {
                throw new InvalidLiquide();
            } else {
                this.volume += quantiteAjoute;
                this.nettoye = false;
            }

        } else {
            if (quantiteAjoute + (volume / capacite) > 1) {
                volume = capacite;
                double futurVolume = quantiteAjoute - (volume - capacite);
                if( futurVolume < CiterneDeTropPlein.capacite){
                    CiterneDeTropPlein.volume = futurVolume;
                }else
     {
         CiterneDeTropPlein.volume = CiterneDeTropPlein.capacite;
         throw new CapacityExceededException((quantiteAjoute - volume));
     }
                throw new CapacityExceededException((quantiteAjoute - volume));
            }
            if (liquideCiterne != liquide) {
                throw new InvalidLiquide();
            } else {
                this.volume += quantiteAjoute * capacite;
                this.nettoye = false;
            }
        }
    }

    public void changeCiterneDeTroplein(Citerne cit) throws RemoveLiquidException, InvalidSetLiquide {

		if(!(cit.getLiquideCiterne()==this.getLiquideCiterne())) {
			cit.enleverLiquide(cit.getCapacite());
			cit.nettoyage();
			cit.setLiquideCiterne(this.liquideCiterne);
		}
		else {
			this.CiterneDeTropPlein=cit;
		}
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

    public Object clone() throws CloneNotSupportedException{
		CiterneSecurise c=null;
		Citerne c2=null;
		try {
			c = (CiterneSecurise)super.clone();
			c2=(Citerne)CiterneDeTropPlein.clone();
            c.changeCiterneDeTroplein(c2);
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}catch (RemoveLiquidException | InvalidSetLiquide e) {

			e.printStackTrace();
		}
		return c;
	}
}

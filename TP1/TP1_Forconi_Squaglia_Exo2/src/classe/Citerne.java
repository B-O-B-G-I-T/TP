package classe;

import java.time.LocalDate;

public class Citerne {

    private static int nbrCiterne = 0;
    public int ID_CITERNE;
    public int capacite;
    private LocalDate dateMiseService;
    protected double volume;
    protected Liquide liquideCinterne;
    protected boolean nettoye;


    public Citerne(int capacite, Liquide liquide)
            throws MinCapacityExeception, MaxException {
        nbrCiterne++;

        if (capacite < 0) {
            throw new MinCapacityExeception();
        } else if (capacite > 20000)
            throw new MaxException();

        this.capacite = capacite;
        this.dateMiseService = LocalDate.now();
        this.liquideCinterne = null;
        this.nettoye = false;

    }

    public void netoyage() {

        liquideCinterne = null;
        nettoye = true;

    }

    public boolean plusAncienne(Citerne c2) {
        return this.dateMiseService.isBefore(c2.dateMiseService);
    }

    @Override
    public String toString() {
        return "Citerne n°" + nbrCiterne + ", type de liquide: " + liquideCinterne + ", capacité : " + capacite
                + " m³, mise en service : " + dateMiseService
                + ", volume occupé: " + volume + " m³";
    }

    public int getNombreCiterne() {
        return nbrCiterne;
    }

    public void ajouterLiquide(double ajouterLiquide, boolean enMetreCube, Liquide liquide)
            throws CapacityExceededException, InvalidLiquide {

        if (enMetreCube == true) {

            if (ajouterLiquide + volume > capacite) {
                volume = capacite;
                throw new CapacityExceededException((ajouterLiquide - volume));
            }
            if(liquideCinterne == null){
                liquideCinterne = liquide;
            }else if (liquideCinterne != liquide) {
                throw new InvalidLiquide();
            } else {
                this.volume += ajouterLiquide;
                this.nettoye = false;
            }

        } else {
                if (ajouterLiquide + (volume / capacite) > 1) {
                    volume = capacite;
                    throw new CapacityExceededException((ajouterLiquide - volume));
                }
                if (liquideCinterne != liquide) {
                throw new InvalidLiquide();
                }else {
                    this.volume += ajouterLiquide * capacite;
                    this.nettoye = false;
                }
        }
    }

    public void enleverLiquide(float quantiteEnleve, boolean enMetreCube) throws RemoveLiquidException {

        if (enMetreCube == true) {
            
                if (quantiteEnleve > volume) {
                    volume = 0;
                    throw new RemoveLiquidException(quantiteEnleve - volume);
                } else {
                    this.volume -= quantiteEnleve;
                }
        } else {
                if (quantiteEnleve > volume / capacite) {
                    volume = capacite;
                    throw new RemoveLiquidException(quantiteEnleve - volume / capacite);
                } else {
                    this.volume += quantiteEnleve * capacite;
                }
        }

    }

    @Override
    public boolean equals(Object obj) {

        return obj != null && obj instanceof Citerne
                && ((Citerne) obj).capacite == this.capacite
                && ((Citerne) obj).dateMiseService.equals(this.dateMiseService)
                && ((Citerne) obj).liquideCinterne == this.liquideCinterne
                && ((Citerne) obj).volume == this.volume;
    }

    // @Override
    public int compareA(Object o) {
        if (o != null && o instanceof Citerne) {
            if (this.volume < ((Citerne) o).volume) {
                return -1;
            } else if (this.volume == ((Citerne) o).volume) {
                if (this.capacite < ((Citerne) o).capacite)
                    return -1;
                if (this.capacite == ((Citerne) o).capacite)
                    return 0;
            } else {
                return 1;
            }
        }
        return -2;
    }
}

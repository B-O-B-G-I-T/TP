package TP1_EXO2.classe;

import java.time.LocalDate;

public class Citerne implements Cloneable {

    private static int nbrCiterne = 0;
    public int ID_CITERNE;
    public int capacite;
    private LocalDate dateMiseService;
    protected double volume;
    protected Liquide liquideCiterne;
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
        this.liquideCiterne = null;
        this.nettoye = false;

    }

    public void nettoyage() {

        liquideCiterne = null;
        nettoye = true;

    }

    public boolean plusAncienne(Citerne c2) {
        return this.dateMiseService.isBefore(c2.dateMiseService);
    }

    @Override
    public String toString() {
        return "Citerne n°" + nbrCiterne + ", type de liquide: " + liquideCiterne + ", capacité : " + capacite
                + " m³, mise en service : " + dateMiseService
                + ", volume occupé: " + volume + " m³";
    }

    public int getNombreCiterne() {
        return nbrCiterne;
    }

    public Liquide getLiquideCiterne() {
        return liquideCiterne;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setLiquideCiterne(Liquide liquideCiterne) throws InvalidSetLiquide {
        if (!this.nettoye) {
            throw new InvalidSetLiquide();
        } else {
            this.liquideCiterne = liquideCiterne;
        }
    }

    public void ajouterLiquide(int ajouterLiquide, Liquide liquide)
            throws CapacityExceededException, InvalidLiquide {

        if (ajouterLiquide + volume > capacite) {
            volume = capacite;
            throw new CapacityExceededException((ajouterLiquide - volume));
        }
        if (liquideCiterne == null) {
            liquideCiterne = liquide;
        } else if (liquideCiterne != liquide) {
            throw new InvalidLiquide();
        } else {
            this.volume += ajouterLiquide;
            this.nettoye = false;
        }

    }

    public void ajouterLiquide(double ajouterLiquide, Liquide liquide)
            throws CapacityExceededException, InvalidLiquide {

        if (ajouterLiquide + (volume / capacite) > 1) {
            volume = capacite;
            throw new CapacityExceededException((ajouterLiquide - volume));
        }
        if (liquideCiterne != liquide) {
            throw new InvalidLiquide();
        } else {
            this.volume += ajouterLiquide * capacite;
            this.nettoye = false;
        }

    }

    public void enleverLiquide(int quantiteEnleve) throws RemoveLiquidException {

        if (quantiteEnleve > volume) {
            volume = 0;
            throw new RemoveLiquidException(quantiteEnleve - volume);
        } else {
            this.volume -= quantiteEnleve;
        }
    }

    public void enleverLiquide(double quantiteEnleve) throws RemoveLiquidException {

        if (quantiteEnleve > volume / capacite) {
            volume = capacite;
            throw new RemoveLiquidException(quantiteEnleve - volume / capacite);
        } else {
            this.volume += quantiteEnleve * capacite;
        }
    }

    @Override
    public boolean equals(Object obj) {

        return obj != null && obj instanceof Citerne
                && ((Citerne) obj).capacite == this.capacite
                && ((Citerne) obj).dateMiseService.equals(this.dateMiseService)
                && ((Citerne) obj).liquideCiterne == this.liquideCiterne
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

    public Object clone() throws CloneNotSupportedException{
        Citerne c = null;
        try {
            c = (Citerne) super.clone();
            c.setLiquideCiterne(liquideCiterne);
            c.ajouterLiquide(capacite, liquideCiterne);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (CapacityExceededException | InvalidLiquide e) {
            e.printStackTrace();
        } catch (InvalidSetLiquide e) {
            e.printStackTrace();
        }
        return c;
    }

}

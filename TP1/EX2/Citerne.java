package EX2;
import java.time.LocalDate;

public class Citerne {

    private static int id=0;
    private int capacite;
    private LocalDate dateMiseService;
    private double volume;
    public enum Liquide {
        Eau(10),
        Vin(15),
        Huile(9);

        private final int temperature; // in degrees
        Liquide(int temperature) {
            this.temperature=temperature;
        }

        private int getTemperature(){
            return temperature;
        }
    }

    public Citerne(int capacite, double volume, Liquide liquide, LocalDate dateMiseService){
        id++;
        try{
            if(capacite>0)
                this.capacite=capacite;
        }
        catch(Exception e){
            System.err.println("Erreur dans la saisie de l'argument, la capacité doit être positive");
        }

        try{
            if(volume>0)
                this.volume=volume;
        }
        catch(Exception e){
            System.err.println("Erreur dans la saisie de l'argument, le volume doit être positive");
        }

        this.dateMiseService=dateMiseService;

        try{
            if(liquide!=Vin) || (liquide!=Eau) || (liquide!=Huile)
                Liquide typeLiquide = Liquide.liquide;
        }
       
        //Liquide liquide = liquide;
    }

    public boolean plusAncienne(Citerne c2){
        return this.dateMiseService.isBefore(c2.dateMiseService);
    }

    @Override
    public String toString() {
        return "Citerne n°"+id+", %s, capacité : "+capacite+" m3, mise en service : "+dateMiseService+", volume occupé : "+volume;
    }
}

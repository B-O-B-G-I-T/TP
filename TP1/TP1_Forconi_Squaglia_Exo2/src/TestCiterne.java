
import javax.sound.midi.Soundbank;

import classe.*;

public class TestCiterne {
    public static void main(String[] args) throws Exception {

        System.out.println("Start \n");
        try {
            Citerne c1 = new Citerne(13, Liquide.vin);
            Citerne c2 = new Citerne(3, Liquide.eau);

            System.out.println(c1 + "/n" + c2);
            System.out.println(c1.getNombreCiterne());
            System.out.println(c1.equals(c2));
            System.out.println(c1.equals(c1));

            try {

                c1.ajouterLiquide(2, true, Liquide.vin);
                c1.ajouterLiquide(15, true, Liquide.vin);
                c1.ajouterLiquide(2, true, Liquide.eau);
            } catch (CapacityExceededException e) {
                e.printStackTrace();
            } catch (InvalidLiquide e) {
                e.printStackTrace();
            }
            try {
                c1.enleverLiquide(5, true); // cas ideal pour enlever du liquide
                c1.enleverLiquide(13, true); // cas où on enleve plus que la capacité max
            } catch (RemoveLiquidException e) {
                e.printStackTrace();
            }

        } catch (MinCapacityExeception e) {
            e.printStackTrace();
        } catch (MaxException e) {
            e.printStackTrace();
        }
        System.out.println("\nEssaie pour les citernes sécurisées");
        try {
            CiterneSecurise sc1 = new CiterneSecurise(300, Liquide.eau, 100);
            CiterneSecurise sc2 = new CiterneSecurise(300, Liquide.eau, 100);

            System.out.println("teste equalité citernes securisées");
           System.out.println(sc1.equals(sc2));

           try {
               System.out.println("teste ajout eau");
               System.out.println("avant" + sc1);
               sc1.ajouterLiquide(350, true, Liquide.eau);
               System.out.println("apres" + sc1);
           } catch (CapacityExceededException e) {
               e.printStackTrace();
           } catch (InvalidLiquide e) {
               e.printStackTrace();
           }

        } catch (MinCapacityExeception e) {
            e.printStackTrace();
        } catch (MaxException e) {
            e.printStackTrace();
        }

        System.out.println("\nTerminé\n");
    }
}
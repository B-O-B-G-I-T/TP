
import javax.sound.midi.Soundbank;

import classe.*;

public class TestCiterne {
    public static void main(String[] args) throws Exception {

        System.out.println("Start \n");
        try {
            Citerne c1 = new Citerne(13, Liquide.vin);
            Citerne c2 = new Citerne(3, Liquide.eau);
            Citerne c3 = new Citerne(3, Liquide.huile);

            System.out.println(c1 + "/n" + c2);
            System.out.println(c1.getNombreCiterne());
            System.out.println(c1.equals(c2));
            System.out.println(c1.equals(c1));

            try {
				Object c4=c1.clone();
				Object c5=c3.clone();
				System.out.println("c5: "+c5);
				System.out.println("c3: "+c3);
			} catch (CloneNotSupportedException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			System.out.println(c2.equals(c3));

            try {

                c1.ajouterLiquide(2, Liquide.vin);
                c1.ajouterLiquide(15, Liquide.vin);
                c1.ajouterLiquide(2, Liquide.eau);
            } catch (CapacityExceededException e) {
                e.printStackTrace();
            } catch (InvalidLiquide e) {
                e.printStackTrace();
            }
            try {
                c1.enleverLiquide(5); // cas ideal pour enlever du liquide
                c1.enleverLiquide(13); // cas où on enleve plus que la capacité max
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
               sc1.ajouterLiquide(350, Liquide.eau);
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
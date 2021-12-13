package EX2;
import java.time.LocalDate;
import EX2.Citerne.Liquide;

public class App {
    public static void main(String[] args) throws Exception {

        LocalDate dateMiseService=LocalDate.of(2021,11,12);
        Liquide Vin = Liquide.Vin;

        Citerne c1 = new Citerne(13, 9.5, Vin, dateMiseService);
        System.out.println(c1);
    }
}
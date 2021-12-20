import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {

        Pair<String, Integer> premierTestPair = new Pair<String, Integer>("le premier element", 1);
        Pair<Integer, Date> secondTestPair = new Pair<Integer, Date>(1, new Date());

        System.out.println("Voici la premiere paire: " + premierTestPair.getPremierAttribut() + " "
                + premierTestPair.getSecondAttribut());
        System.out.println("Voici la Second paire: " + secondTestPair.getPremierAttribut() + " "
                + secondTestPair.getSecondAttribut());

    }
}

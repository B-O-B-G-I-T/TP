package EX1;
import java.util.ArrayList;

public class MonTableau implements EstComparable {

    public ArrayList<Integer> tableau;

    MonTableau(int[] a) {
        tableau = new ArrayList<Integer>();
        for (int i : a) {
            tableau.add(i);
        }
    };

    @Override
    public int compareA(Object o) {
        MonTableau k = (MonTableau) o;
        int somme1 = 0;
        int somme2 = 0;

        int iteration = Math.max(tableau.size(), k.tableau.size());

        for (int i = 0; i < iteration; i++) {

            try {

                if (tableau.get(i) != null)
                    somme1 += tableau.get(i);
            } catch (Exception e) {
                // TODO: handle exception
            }

            try {
                if (k.tableau.get(i) != null)
                    somme2 += k.tableau.get(i);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        if (somme1 < somme2)
            return -1;
        else if (somme1 == somme2)
            return 0;
        else
            return 1;

    };
}

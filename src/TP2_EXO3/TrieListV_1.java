package TP2_EXO3;

import java.util.*;

public class TrieListV_1 {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in); // Reading from System.in
        Random rand = new Random();
        System.out.println("Entrez le nombre de entier que vous voulez");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        // once finished
        reader.close();
        // la collection de type array list
        List<Integer> l = new ArrayList<Integer>();

        for (; n > l.size();) {
            l.add(rand.nextInt(1001));
        }
        // on trie la collection
        Collections.sort(l);

        // on affiche la collection
        for (Integer integer : l) {
            System.out.println(integer + ", ");
        }
    }
}

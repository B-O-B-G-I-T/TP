package TP2_EXO3;

import java.util.*;

public class TrieListV_2 {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in); // Reading from System.in
        Random rand = new Random();
        System.out.println("Entrez le nombre de entier que vous voulez");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        // once finished
        reader.close();

        // // la collection de type array list
        SortedSet<Integer> s = new TreeSet<Integer>();


        for (; n > s.size();) {
            s.add(rand.nextInt(1001));
        }
        // on trie la collection
        
        // on affiche la collection
        for (Integer integer : s) {
            System.out.println(integer + ", ");
        }
    }
}

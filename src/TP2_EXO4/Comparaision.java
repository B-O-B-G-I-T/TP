package TP2_EXO4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparaision {

    static final Comparator<String> InverseComparator = new Comparator<String>() {
        public int compare(String e1, String e2) {
            return e2.compareTo(e1);
        }
    };
    static final Comparator<String> militaireComparator = new Comparator<String>() {
       
        public int compare(String e1, String e2) {
            return e1.length() - e2.length();
        }
    };

    public static void main(String[] args) {
        //ComparatorMilitaire compMilitaire = new ComparatorMilitaire();
        List<String> c = new ArrayList<String>();

        for (String v : args) {
            c.add(v);
        }

        System.out.println("Sans le trie " + c);
        Collections.sort(c);
        System.out.println("Trie lexical " + c);
        Collections.sort(c, militaireComparator);
        System.out.println("trie militaire " + c);
        Collections.sort(c, InverseComparator);
        System.out.println("trie inverse " + c);

    }

}

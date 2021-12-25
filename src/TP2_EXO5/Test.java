package TP2_EXO5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        Collection<Personne> c = new ArrayList<Personne>();

        Personne p1 = new Personne("Fo","jean", 20, LocalDate.now(), null);
        Personne p2 = new Personne("F", "jean", 20, LocalDate.now(), null);
        Personne p3 = new Personne("F", "jea", 20, LocalDate.now(), null);
        Personne p4 = new Personne("Fo", "jean", 19, LocalDate.now(), null);
        Personne p5 = new Personne("Fo", "jean", 20, LocalDate.now(), null);

        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);

        System.out.println("sans trie " + c);
        Collections.sort((ArrayList<Personne>) c);
        System.out.println("Avec trie " + c);
        Collections.sort((ArrayList<Personne>) c);

    }
}

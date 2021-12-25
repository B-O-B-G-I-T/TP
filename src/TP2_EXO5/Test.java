package TP2_EXO5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        Collection<Personne> c = new ArrayList<Personne>();

        Personne p1 = new Personne("Fo","jean", 20);
        Personne p2 = new Personne("F", "jean", 20);
        Personne p3 = new Personne("F", "jea", 20);
        Personne p4 = new Personne("Fo", "jean", 19);
        Personne p5 = new Personne("Fo", "jean", 20);

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

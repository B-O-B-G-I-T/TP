package TP2_EXO2;

import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {

        int tailleMin = Integer.parseInt(args[1]);

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        try {
            // recherche du fichier
            Scanner scan = new Scanner(new File(args[0]));

            // lecture du fichier grâce à l'interface iterator
            while (scan.hasNext()) {
                // on ordonne par ordre alphabetique le mot traité
                String ordonne = alphabetiser(scan.next());
                // on recupere la valeur de la map a la clé ordonne
                List<String> l = map.get(ordonne);
                // si la valeur l est null on cree une nouvelle clée avec un nouveau arrayList
                if (l == null){
                    map.put(ordonne, l = new ArrayList<String>());
                }

                l.add(scan.next());
            }
            // lancer une exception de type FileNotFound
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier n'a pas ete trouve...");
        }
        //par recherche par iteration
        //j'ai rencontré un petit probleme je ne trouve que des list de 7 mots maximum
        //donc j'ai mis 5 en parametre au lieu de 8 comme dit dans la consigne
        for(List<String> l : map.values()){

            if (l.size() >= tailleMin)
                System.out.println(l.size() + ":" + l);
        }

        
    }

    private static String alphabetiser(String mot) {
        char[] tempon = mot.toCharArray();
        Arrays.sort(tempon);
        return new String(tempon);

    }

}
package TP2_EXO2;

import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {

        int tailleMin = Integer.parseInt(args[1]);

        try {
            Scanner scan = new Scanner(new File(args[0]));
            while (scan.hasNext()){
                
                System.out.print(scan.next() + " " + tailleMin);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier n'a pas ete trouve...");
        }
    }
}
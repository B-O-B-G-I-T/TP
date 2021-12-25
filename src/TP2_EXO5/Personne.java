package TP2_EXO5;

import java.util.Comparator;

public class Personne implements Comparable<Personne>, Comparator<Personne>{

    private int age;
	private String nom;
	private String prenom;

	public Personne(String prenom, String nom, int age) {
		this.age = age;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public int compareTo(Personne o) {
		
		int res = 0;
		if (this.age > o.age)
			res = 1;
		else if (this.age < o.age)
			res = -1;
		else {
			res = compare(this, o);
		}
		return res;
	}

	@Override
	public int compare(Personne o1, Personne o2) {
		
		int resultat = 0;
		int Nom = o1.nom.compareToIgnoreCase(o2.nom);
		if (Nom > 0) {
			resultat = Nom;
		} else if (Nom < 0) {
			resultat = Nom;
		} else if (o1.prenom.compareToIgnoreCase(o2.prenom) < 0) {
				resultat = o1.prenom.compareToIgnoreCase(o2.prenom);
			
		}
		return resultat;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nNom: " + nom + " Prenom: " + prenom + " Age: " + age;
	}
}

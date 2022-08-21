package application;

import java.io.IOException;
import java.util.ArrayList;




/********* la classe Commande ********/


public class Commande {
	
	//déclaration d'un tableau nommé commande

	private ArrayList commande = new ArrayList();
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	
	
//Fonction qui permet d'ajouter une pizza (son type , sa taille et ses supplèmments ) dans le tableau commande  
	
	
	public void ajouterPizza(String nom,String taille,ArrayList supplements) throws IOException{
		
		this.commande.add(new pizza(nom,taille,supplements));
		
	}
	
//fonction qui permet de supprimer une pizza à partir du tableau de commande 	
	public void supprimerPizza() {
		
		this.commande.remove((commande.size())-1);
		
	}
	

	
//calcul de la taille du tableau commande  
	public int taille(){
		
		return commande.size();
	}

	
//récupération d'une pizza à partir du tableau commande	
	public pizza commandei(int i){
		
		return (pizza) commande.get(i);
	}
}

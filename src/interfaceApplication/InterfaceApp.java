package interfaceApplication;

import java.io.IOException;





import java.util.ArrayList;

import application.Commande;
import application.pizza;




/******* La classe de l'interface d'application**/
public class InterfaceApp {

	
	
	//Déclaration d'une variable commande de la classe Commande 
	
	private Commande commande;
	public InterfaceApp() {
		// TODO Auto-generated constructor stub
		commande= new Commande();
	}
	
	
// méthode de calcul d'un prix de pizza
public double calculerPrixPIzza(String nom,String taille) throws IOException{
		
		
		//déclaration d'un tableau de supplement 
		ArrayList supplements = new ArrayList();
		
		//on instancie un objet de type pizza
		pizza pz=new pizza(nom,taille,supplements);
		
		//on recupère le prix du pizza à partir de la méthode getPrix Pizza située dans le noyeux  
		return pz.getPrixPizza();
		
	}
	





	
	
//méthode de calcul du prix des suppléments 
	
	public double calculerPrixSupplements(String nom,String taille,ArrayList supplements) throws IOException{
		ArrayList supp = new ArrayList();
		
//déclaration de 2 objet de type pizza qui ont le meme nom, meme taille avec des supplèments differents  		
		pizza pz=new pizza(nom,taille,supplements);
		pizza pz1=new pizza(nom,taille,supp);
//on récupère le prix des supplèments, c'est la soustraction des 2 objets   
		return (pz.getPrixPizza()-pz1.getPrixPizza());
		
	}
	
//méthode d'ajout d'un type de pizza 
	public void ajouterPizza(String nom,String taille,ArrayList supplements) throws IOException{

		//on fait appel au méthode ajouter pizza située dans la classe commande		
		
		commande.ajouterPizza(nom,taille,supplements);
	}
	

//méthode de suppression d'un pizza 
	
	public void supprimerPizza(){

		//on fait appel au méthode supprimer pizza située dans la classe commande		
		
		commande.supprimerPizza();
	}
	

//méthode de suppression d'une commande 
	public void supprimerCommande(){
		
		
		// on recupère la taille de la commande 
		int i,j=commande.taille();
		
		//on parcourt l'ensemble des pizzas situées dans le tableau de commande 
		for(i=0;i<j;i++)
		{
		//on fait appel au méthode de suppresion d'un pizza 	
		commande.supprimerPizza();
		}
	}
	
	public int taille(){
		
		return commande.taille();
	}
	
	
//méthode de calcul de la somme total d'un commande 	
	public double SommeTotal(){
		
		int i;double s=0;
		//on parcourt toutes les pizzas qui se trouve dans la commande grace à la méthode taille 
		for(i=0;i<commande.taille();i++)
		{
			//on additionne les prix des pizzas 
			s=s+commande.commandei(i).getPrixPizza();
		}
		
		return s;
	}
	
}

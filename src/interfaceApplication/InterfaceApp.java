package interfaceApplication;

import java.io.IOException;





import java.util.ArrayList;

import application.Commande;
import application.pizza;




/******* La classe de l'interface d'application**/
public class InterfaceApp {

	
	
	//D�claration d'une variable commande de la classe Commande 
	
	private Commande commande;
	public InterfaceApp() {
		// TODO Auto-generated constructor stub
		commande= new Commande();
	}
	
	
// m�thode de calcul d'un prix de pizza
public double calculerPrixPIzza(String nom,String taille) throws IOException{
		
		
		//d�claration d'un tableau de supplement 
		ArrayList supplements = new ArrayList();
		
		//on instancie un objet de type pizza
		pizza pz=new pizza(nom,taille,supplements);
		
		//on recup�re le prix du pizza � partir de la m�thode getPrix Pizza situ�e dans le noyeux  
		return pz.getPrixPizza();
		
	}
	





	
	
//m�thode de calcul du prix des suppl�ments 
	
	public double calculerPrixSupplements(String nom,String taille,ArrayList supplements) throws IOException{
		ArrayList supp = new ArrayList();
		
//d�claration de 2 objet de type pizza qui ont le meme nom, meme taille avec des suppl�ments differents  		
		pizza pz=new pizza(nom,taille,supplements);
		pizza pz1=new pizza(nom,taille,supp);
//on r�cup�re le prix des suppl�ments, c'est la soustraction des 2 objets   
		return (pz.getPrixPizza()-pz1.getPrixPizza());
		
	}
	
//m�thode d'ajout d'un type de pizza 
	public void ajouterPizza(String nom,String taille,ArrayList supplements) throws IOException{

		//on fait appel au m�thode ajouter pizza situ�e dans la classe commande		
		
		commande.ajouterPizza(nom,taille,supplements);
	}
	

//m�thode de suppression d'un pizza 
	
	public void supprimerPizza(){

		//on fait appel au m�thode supprimer pizza situ�e dans la classe commande		
		
		commande.supprimerPizza();
	}
	

//m�thode de suppression d'une commande 
	public void supprimerCommande(){
		
		
		// on recup�re la taille de la commande 
		int i,j=commande.taille();
		
		//on parcourt l'ensemble des pizzas situ�es dans le tableau de commande 
		for(i=0;i<j;i++)
		{
		//on fait appel au m�thode de suppresion d'un pizza 	
		commande.supprimerPizza();
		}
	}
	
	public int taille(){
		
		return commande.taille();
	}
	
	
//m�thode de calcul de la somme total d'un commande 	
	public double SommeTotal(){
		
		int i;double s=0;
		//on parcourt toutes les pizzas qui se trouve dans la commande grace � la m�thode taille 
		for(i=0;i<commande.taille();i++)
		{
			//on additionne les prix des pizzas 
			s=s+commande.commandei(i).getPrixPizza();
		}
		
		return s;
	}
	
}

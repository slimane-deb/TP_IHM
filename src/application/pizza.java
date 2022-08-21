package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/********* la classe pizza ********/



public class pizza {

	
	//Le nom du pizza
	private String nom =new String(); 
	
	
	//La taille du pizza
	private String taille;
	
	//Un tableau contenant l'ensemble des supplèments 
	private ArrayList supplements = new ArrayList();
	
	//Le prix du pizza  
	private double prixPizza;
	
	
	public pizza (String nom,String taille,ArrayList supplements) throws IOException {
		
		this.nom=nom;
		this.supplements.addAll(supplements);
		this.taille=taille;
		prixPizza=calculerPrix(nom,taille,supplements);
	}
	 
	//fonction qui permet de calculer le prix d'un pizza 
	
	public double calculerPrix (String nom,String taille,ArrayList supplements) throws IOException {
	
		double prix=0.0;
	
	//on récupère les prix des pizzas  à partir d'un fichier nommé Type pizza 
	File file = new File("images/TypePizza/TypePizza.txt");
	
	FileReader fr;
	
	String str = "";
	
	
	//Création de l'objet de lecture
	
	
	fr = new FileReader(file);
	int i=0;
	
	//Lecture des données
	
	while((i = fr.read()) != -1)
	{
	if(i!=32) str += (char)i;
	else
	{
		if(str.compareTo(nom)==0)
		{
			str="";
			while((i = fr.read()) != -1)
			{
			if(i!=32) str += (char)i;
			else
			{try
			{
			prix =Double.parseDouble(str);
			
			
			} catch (NumberFormatException e)
			{
				prix=0.0;
			}
			str="";
			break;
			}
			}
		}
		else str="";
			
	}
	}
	fr.close();
	
	// on récupère les tailles des pizzas situé dans le fichier taille pizza 
	File file3 = new File("images/TaillePizza/TaillePizza.txt");
	FileReader fr3;
	str = "";
	//Création de l'objet de lecture
	fr3 = new FileReader(file3);
	i=0;
	//Lecture des données
	
	while((i = fr3.read()) != -1)
	{
	if(i!=32) str += (char)i;
	else
	{
		if(str.compareTo(taille)==0)
		{
			str="";
			while((i = fr3.read()) != -1)
			{
			if(i!=32) str += (char)i;
			else
			{try
			{
			// on multiplie le prix initial du pizza fois le prix de la taille
			prix =prix*Double.parseDouble(str);
			} catch (NumberFormatException e)
			{
				prix=prix;
			}
			str="";
			break;
			}
			}
		}
		else str="";
			
	}
	}
	fr3.close();
	
	
	// on rècupère le prix des supplèments situé dans le fichier SupplementsPizza 
	File file2 = new File("images/SupplementsPizza/SupplementsPizza.txt");
	str = "";
	
	//Création de l'objet de lecture
	
	i=0;int k=0;
	//Lecture des données
	
	
	for (k=0;k<supplements.size();k++)
	{
	FileReader fr2 = new FileReader(file2);
	while((i = fr2.read()) != -1)
	{
	if(i!=32) str += (char)i;
	else
	{
		if(str.compareTo((String)supplements.get(k))==0)
		{
			str="";
			while((i = fr2.read()) != -1)
			{
			if(i!=32) str += (char)i;
			else
			{try
			{
				
			// on somme le prix des supplèments avec le prix du pizza 
			prix =prix+Double.parseDouble(str);
			} catch (NumberFormatException e)
			{
				prix=prix+0.0;
			}
			str="";
			break;
			}
			}
		}
		else str="";
			
	}
	}
	fr2.close();
	}
	

return prix;
	}
	
	
	//déclaration des setters et des getters 
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public ArrayList getSupplements() {
		return supplements;
	}
	public void setSupplements(ArrayList supplements) {
		this.supplements = supplements;
	}
	public double getPrixPizza() {
		return prixPizza;
	}
	public void setPrixPizza(double prix) {
		this.prixPizza = prixPizza;
	}
	
}

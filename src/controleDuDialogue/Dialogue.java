package controleDuDialogue;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import interfaceApplication.InterfaceApp;
import Presentation.affichage;





/***********La classe du module de controle de dialogue ***************/

public class Dialogue {
	
	private affichage fenetre;
	
	private InterfaceApp inter;
	
	boolean verif,verif1;
	
	
	public Dialogue( affichage fenetre) {
		// TODO Auto-generated constructor stub
		this.fenetre=fenetre;
		inter= new InterfaceApp();
	}

	
//demande choix permet de r�cuperer le choix fait par l'utilisateur 	
	
	public void demandeChoix() throws IOException{
		
		//on recup�re le nom de la pizza , sa taille et on calcule le prix grace � la fonction calculer pizza situ�e dans l'interface application 
		double prix=inter.calculerPrixPIzza(fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection());
		
		//on affecte le prix  du pizza dans l'interface d'utilisateur 
		fenetre.setPrixPizza(prix);
		
		
		
		// on r�cup�re les prix des supplements choisies par l'utilisateur et on calcule le prix des suppl�ments   
		double prix1=inter.calculerPrixSupplements(fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection(),fenetre.getSupplmentPizzaSellection());
		
		
		//on affiche le prix des suppl�ments dans la presentation  
		fenetre.setprixsupplements(prix1);
		
		
		
		// on met � jour  le prix total d'une pizza dans l'interface d'utilisateur 
		fenetre.setprixTotalePizza(prix+prix1);
		
		// on met � jour le nom et l'image de la pizza selectionn�e dans l'interface utilisateur 
		fenetre.setNomPizza(fenetre.getNomPizzaSellection());
		fenetre.setImagePizza(fenetre.getImagePizzaSellection());
		
	}
	
	
	
// fonction qui permet d'ajouter une pizza dans le r�capitulatif
	
// elle retourne un booleen juste pour gerer les messages d'erreurs 	
	
	public boolean demandeSelection() throws IOException{
		
		
		
		double prix=inter.calculerPrixPIzza(fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection());
		
		// on v�rifie si le montant d'une pizza n'est pas z�ro 
		if(prix!=0.0){
			
		double prix1=inter.calculerPrixSupplements(fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection(),fenetre.getSupplmentPizzaSellection());
		
		// on d�clare une ligne qui contient le nom du pizza , sa taille , ses suppl�ments ainsi que le prix total d'une pizza    
		
		Object[] lineData={fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection(),fenetre.getSupplmentPizzaSellection(),prix+prix1};
		
		
		
		//on met � jour le controleur  
		inter.ajouterPizza(fenetre.getNomPizzaSellection(),fenetre.getTaillePizzaSellection(),fenetre.getSupplmentPizzaSellection());
		
		//on affecte la ligne  dans l'interface d'utilisateur (dans le r�capitulatif) 
		fenetre.ajouterPizza(lineData);
		
		// on met � jour aussi le nombre total des pizza
		fenetre.setNbrPizza(inter.taille());
		
		//on met � jour le prix total 
		fenetre.setPrixTotal(inter.SommeTotal());
		verif=true;
		
		}
		else 
		{
			//un bool�en pour afficher des messages d'erreur
			verif=false;
			
		}
		
		return verif;
	} 
	
	// fonction qui permet d'effacer une pizza � partir d'une commande 
	
	public boolean demandeEffacerDernier(){
		
		// on v�rifie s'il existe des pizzas dans la commande 
		if(inter.taille()>0) {
		
		// on affecte la suppression dans l'interface utilisateur 
		fenetre.supprimerPizza();
		// on met � jour le controlleur 
		inter.supprimerPizza();
		
		fenetre.setNbrPizza(inter.taille());
		fenetre.setPrixTotal(inter.SommeTotal());
		verif1=true;

		}
		else {
			verif1=false;
			
		}
		
		return verif1;
		}
	
	
// pour effacer la commande     	
public void demandeEffacerListe(){
		if(inter.taille()>0) {
			
			
			
			
			//on fait appel au m�thode de supprimer une commande   	
			fenetre.supprimmerCommande();
			// on met � jour le dialogue 
			inter.supprimerCommande();
			// on met � jour lr nombre total des pizzas et le montant total  
			fenetre.setNbrPizza(inter.taille());
			fenetre.setPrixTotal(inter.SommeTotal());
		
		}
		
		
}
// pour enovoyer une commande 	
public void demandeEnvoyerListe(){

	if(inter.taille()>0) {
		
		fenetre.supprimmerCommande();
		inter.supprimerCommande();
		fenetre.setNbrPizza(inter.taille());
		fenetre.setPrixTotal(inter.SommeTotal());
		
	}
	else 
	{
		JOptionPane jop2 = new JOptionPane();
		jop2.showMessageDialog(null,"Vous n'avez aucune commande","Erreur", JOptionPane.ERROR_MESSAGE);	
		
	}
		
	}
	

 


// pour quitter l'application 

public void demandeQuiter()
{
	System.exit(0);
    

	
}
}

package Presentation;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


/*******La classe Smodel permet de faciliter la manipulation des tableaux***/
public class SModel extends DefaultTableModel {
	//Constructeur
	
	public SModel(Object[][] data, String[] title){
	super(data,title);
	}
	//lors de l'édition d'une cellule 
	public boolean isCellEditable(int row, int col){
		return false;
		}
	/**
	 * @param args
	 */
}

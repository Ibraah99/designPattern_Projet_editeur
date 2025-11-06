package controleur.commande;

import modele.CarteDeSouhait;
import modele.Decoration;
import modele.Decoration.ELEMENT;
import vue.VueCarteditor;

public class CommandeInsererElement extends Commande{
	
	protected double x;
	protected double y;
	protected ELEMENT itemChoisi;
	protected CarteDeSouhait carteDeSouhait;
	protected Decoration nouveauItem;
	public CommandeInsererElement( ELEMENT item ,double x, double y, CarteDeSouhait carteDeSouhait) {
		this.x = x;
		this.y = y;
		this.itemChoisi = item;
		this.carteDeSouhait = carteDeSouhait;
		
	}

	@Override
	public void executer() {
		if (itemChoisi != null) {
			this.nouveauItem = new Decoration(this.itemChoisi,x,y);
			carteDeSouhait.getElements().add(nouveauItem);
			// carteDeSouhait.ajouterElement(new Decoration(itemChoisi, x, y));  
		      VueCarteditor.getInstance().afficherItem(itemChoisi, x, y);
		           
		}
	}

	@Override
	public void annuler() {
		VueCarteditor.getInstance().supprimerItem(itemChoisi, x, y);
		this.carteDeSouhait.getElements().remove(nouveauItem);
		
	}

	@Override
	public void refaire() {
		// TODO Auto-generated method stub
		
	}

}

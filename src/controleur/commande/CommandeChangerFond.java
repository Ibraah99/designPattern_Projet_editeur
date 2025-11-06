package controleur.commande;

import modele.CarteDeSouhait;
import modele.Fond;
import modele.Fond.FOND;
import vue.VueCarteditor;

public class CommandeChangerFond extends Commande  {
	
	protected FOND fondChoisi ;
	protected CarteDeSouhait carteDeSouhait;
	protected FOND ancienFond;
	protected FOND nouveauFond;
	
	public CommandeChangerFond(FOND fond, CarteDeSouhait carte) {
		this.fondChoisi = fond;
		this.carteDeSouhait = carte;
	}

	@Override
	public void executer() {
		
		this.ancienFond = carteDeSouhait.getFond().getFond();
		 carteDeSouhait.setFond(new Fond(fondChoisi));	
	     VueCarteditor.getInstance().afficherFond(fondChoisi);
	       	
	}

	@Override
	public void annuler() {
		VueCarteditor.getInstance().afficherFond(ancienFond);
		this.carteDeSouhait.setFond(new Fond(ancienFond));
		
	}

	@Override
	public void refaire() {
	    VueCarteditor.getInstance().afficherFond(fondChoisi);
	    carteDeSouhait.setFond(new Fond(fondChoisi));
	}

}

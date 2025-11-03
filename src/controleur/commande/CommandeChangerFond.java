package controleur.commande;

import modele.CarteDeSouhait;
import modele.Fond;
import modele.Fond.FOND;
import vue.VueCarteditor;

public class CommandeChangerFond extends Commande  {
	
	protected FOND fondChoisi ;
	protected CarteDeSouhait carteDeSouhait;
	
	public CommandeChangerFond(FOND fond, CarteDeSouhait carte) {
		this.fondChoisi = fond;
		this.carteDeSouhait = carte;
	}

	@Override
	public void executer() {
		
	       VueCarteditor.getInstance().afficherFond(fondChoisi);
	        carteDeSouhait.setFond(new Fond(fondChoisi));		
	}

}

package controleur.commande;

import modele.CarteDeSouhait;
import modele.Emoticon;
import modele.Emoticon.EMOTICON;
import vue.VueCarteditor;

public class CommandeInsererEmoticon extends Commande {
	
	protected double x;
	protected double y;
	protected EMOTICON emoticonChoisi;
	protected CarteDeSouhait carteDeSouhait;
	public CommandeInsererEmoticon( EMOTICON emoticon ,double x, double y, CarteDeSouhait carteDeSouhait) {
		this.x = x;
		this.y = y;
		this.emoticonChoisi = emoticon;
		this.carteDeSouhait = carteDeSouhait;
		
	}

	@Override
	public void executer() {
		
		 if (emoticonChoisi != null) {
	            VueCarteditor.getInstance().afficherEmoticon(emoticonChoisi, x, y);
	            carteDeSouhait.ajouterEmoticon(new Emoticon(emoticonChoisi, x, y));
	        }
		
	}

}

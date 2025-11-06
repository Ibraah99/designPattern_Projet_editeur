package controleur.commande;

import modele.CarteDeSouhait;
import modele.Decoration;
import modele.Emoticon;
import modele.Emoticon.EMOTICON;
import vue.VueCarteditor;

public class CommandeInsererEmoticon extends Commande {
	
	protected double x;
	protected double y;
	protected EMOTICON emoticonChoisi;
	protected Emoticon nouveauEmoticon;
	protected CarteDeSouhait carteDeSouhait;
	public CommandeInsererEmoticon( EMOTICON emoticon ,double x, double y, CarteDeSouhait carte) {
		this.x = x;
		this.y = y;
		this.emoticonChoisi = emoticon;
		this.carteDeSouhait = carte;
		
	}

	@Override
	public void executer() {
		
		 if (emoticonChoisi != null) {
			 
			 this.nouveauEmoticon = new Emoticon(this.emoticonChoisi,x,y);
				carteDeSouhait.getEmoticon().add(nouveauEmoticon);
			    carteDeSouhait.ajouterEmoticon(new Emoticon(emoticonChoisi, x, y));
	            VueCarteditor.getInstance().afficherEmoticon(emoticonChoisi, x, y);
	            
	        }
		
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void annuler() {
		VueCarteditor.getInstance().supprimerEmoticon(emoticonChoisi, x, y);
		this.carteDeSouhait.getElements().remove(nouveauEmoticon);
		
	}

	@Override
	public void refaire() {
		// TODO Auto-generated method stub
		
	}

}

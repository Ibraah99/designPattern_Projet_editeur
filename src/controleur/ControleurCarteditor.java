package controleur;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import donnee.Exporteur;
import modele.Theme.THEME;
import modele.CarteDeSouhait;
import modele.Decoration;
import modele.Decoration.ELEMENT;
import modele.Emoticon;
import modele.Emoticon.EMOTICON;
import modele.Fond;
import modele.Saisie;
import modele.Fond.FOND;
import vue.VueCarteditor;

public class ControleurCarteditor extends Controleur {

	protected ELEMENT itemChoisi;
    protected FOND fondChoisi = null;
    protected EMOTICON emoticonChoisi;
    protected String texteChoisi = null;
    CarteDeSouhait carteDeSouhait  = new CarteDeSouhait();
    Fond fond = new Fond(fondChoisi);
   
   

    public ControleurCarteditor() {
        Logger.logMsg(Logger.INFO, "new ControleurCarte()");
    }

    public void initialiser() {
    	
    }

    public void notifierClicCarte(double x, double y) {
           
        if (itemChoisi != null) {
            VueCarteditor.getInstance().afficherItem(itemChoisi, x, y);
            carteDeSouhait.ajouterElement(new Decoration(itemChoisi, x, y));
        }

        if (emoticonChoisi != null) {
            VueCarteditor.getInstance().afficherEmoticon(emoticonChoisi, x, y);
            carteDeSouhait.ajouterEmoticon(new Emoticon(emoticonChoisi, x, y));
        }
            
    }

    public void notifierChoixItem(ELEMENT item) {
        this.itemChoisi = item;
        this.emoticonChoisi = null; 
        System.out.println("L'item sélectionné est : " + item);
    }


    public void notifierChoixEmoticon(EMOTICON emoticon) {
    	this.emoticonChoisi = emoticon;
    	this.itemChoisi = null; 
    	System.out.println("L'emoticon sélectionné est : " + emoticon);
    	
		//VueCarteditor.getInstance().afficherEmoticon(emoticonChoisi);
	}
    
   
        

    public void notifierChoixFond(FOND fondChoisi) {

    	
        VueCarteditor.getInstance().afficherFond(fondChoisi);
        carteDeSouhait.setFond(new Fond(fondChoisi));
    }

	public void notifierChoixTheme(THEME themeChoisi) {
		VueCarteditor.getInstance().afficherTheme(themeChoisi);
		
		
	}

	public void notifierClicSauvegarder() {
		
		System.out.println("ControleurCarteditor.notifierClicSauvegarder()");
	       Exporteur exporteur = new Exporteur();
	        exporteur.sauvegarder(this.carteDeSouhait);
	        
	
		
	}

	public void notifierSaisie(String texte, String couleurHex) {
	    System.out.println("Saisie enregistrée : " + texte +  "; de couleur : " + couleurHex);
	    carteDeSouhait.setSaisie(new Saisie(texte));
	    carteDeSouhait.setCouleurHex(couleurHex);
	}



        
 

}
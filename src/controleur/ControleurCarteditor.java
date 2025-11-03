package controleur;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import controleur.commande.CommandeChangerFond;
import controleur.commande.CommandeInsererElement;
import controleur.commande.CommandeInsererEmoticon;
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
    	
    	CommandeInsererElement commande = new CommandeInsererElement(itemChoisi, x, y, carteDeSouhait);
    	commande.executer();
    	
    	CommandeInsererEmoticon commande2 = new CommandeInsererEmoticon(emoticonChoisi, x, y, carteDeSouhait);
    	commande2.executer();
           
 

       
            
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
    	
    	CommandeChangerFond commande = new CommandeChangerFond(fondChoisi, carteDeSouhait);
    	commande.executer();

    	
 
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
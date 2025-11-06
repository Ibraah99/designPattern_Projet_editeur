package vue;
import java.util.HashMap;
import java.util.Hashtable;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurCarteditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.Decoration;
import modele.Decoration.ELEMENT;
import modele.Emoticon;
import modele.Emoticon.EMOTICON;
import modele.Fond;
import modele.Fond.FOND;
import modele.Theme;
import modele.Theme.THEME;
import vue.environnement.SelecteurDeFond;
import vue.environnement.SelecteurElement;
import vue.environnement.SelecteurEmoticon;

public class VueCarteditor extends Vue {
	
	protected String texteAffichage;

	protected ControleurCarteditor controleur;
	protected static VueCarteditor instance = null; 
	public static VueCarteditor getInstance() {if(null==instance)instance = new VueCarteditor();return VueCarteditor.instance;}; 
	Hashtable<Decoration.ELEMENT, String>imagesElement;
	Hashtable<Fond.FOND, String>imagesFond;
	Hashtable<Theme.THEME, String>imagesTheme;
	Hashtable<Emoticon.EMOTICON, String>imagesEmoticon;
	
	
	private VueCarteditor() 
	{
		super("carteditor.fxml", VueCarteditor.class, 1294,743);
		super.controleur = this.controleur = new ControleurCarteditor();
		Logger.logMsg(Logger.INFO, "new VueCarteditor()");
		
		this.imagesTheme = new Hashtable<Theme.THEME, String>();
		imagesTheme.put(Theme.THEME.THEME1, "theme1.png");
		imagesTheme.put(Theme.THEME.THEME2, "theme2.png");
		imagesTheme.put(Theme.THEME.THEME3, "theme3.png");
		imagesTheme.put(Theme.THEME.THEME4, "theme4.png");
		
		
		this.imagesFond = new Hashtable<Fond.FOND, String>();
		imagesFond.put(Fond.FOND.FOND1, "fond1.png" );
		imagesFond.put(Fond.FOND.FOND2, "fond2.png" );
		imagesFond.put(Fond.FOND.FOND3, "fond3.png" );
		imagesFond.put(Fond.FOND.FOND4, "fond4.png" );
		
		this.imagesElement = new Hashtable<Decoration.ELEMENT, String>();
		imagesElement.put(Decoration.ELEMENT.TIMBRE, "timbre.png");
		imagesElement.put(Decoration.ELEMENT.SOULIER, "soulier.png");
		imagesElement.put(Decoration.ELEMENT.TSHIRT, "tshirt.png");
		imagesElement.put(Decoration.ELEMENT.VOEUX, "voeux.png");
		
		this.imagesEmoticon = new Hashtable<Emoticon.EMOTICON, String>();
		imagesEmoticon.put(Emoticon.EMOTICON.DRAGON, "dragon.png");
		imagesEmoticon.put(Emoticon.EMOTICON.FLEUR, "fleur.png");
		imagesEmoticon.put(Emoticon.EMOTICON.OISEAU, "oiseau.png");
		imagesEmoticon.put(Emoticon.EMOTICON.EMOJI, "emoji.png");
		

		
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.BLACK); 
		colorPicker.setPrefWidth(150);
		colorPicker.setStyle("-fx-cursor: hand;");
		colorPicker.setTooltip(new Tooltip("Choisir une couleur de texte"));
		
		HBox choixTerrain = (HBox) lookup("#choix-terrain");
		choixTerrain.getChildren().add(colorPicker);
		
		TextArea texte = (TextArea) lookup("#action-modifier-texte");
		//texteAffichage = texte.getText();
    	//controleur.notifierSaisie(texteAffichage);
	    //controleur.notifierClicSauvegarder();
		colorPicker.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				Color couleurChoisie = colorPicker.getValue();
				
				if(texte != null) {
				
					
					String couleurText = String.format("#%02X%02X%02X", (int)(couleurChoisie.getRed() * 255), (int)(couleurChoisie.getGreen() * 255), (int)(couleurChoisie.getBlue() * 255));
					texte.setStyle("-fx-background-color: transparent;-fx-border-color: transparent; -fx-text-fill: "+couleurText+  ";-fx-font-size: 26px;-fx-font-family: 'Berlin Sans FB'");
					//texte.setStyle("-fx-text-fill: " + couleurText + ";");
					System.out.println("Texte du champ coloré en " + couleurText);
				}
			
				
			}});
		
		
		
		Button actionSauvegarder = (Button)lookup("#action-sauvegarder");
        actionSauvegarder.setOnAction(new EventHandler<ActionEvent>() {

	     @Override
			public void handle(ActionEvent e) {
	    	 
	    	  String contenu = texte.getText();

	    	    
	    	    Color couleur = colorPicker.getValue();
	    	    String couleurHex = String.format("#%02X%02X%02X",
	    	        (int)(couleur.getRed()*255), (int)(couleur.getGreen()*255), (int)(couleur.getBlue()*255));

	    	    
	    	    controleur.notifierSaisie(contenu, couleurHex);
	    	 
		    controleur.notifierClicSauvegarder();
				
				
			}});
        
		Button actionUndo = (Button) lookup("#action-undo");
		actionUndo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				controleur.notifierActionUndo();
				
			}});
		
		
		Button actionRedo = (Button) lookup("#action-redo");
		actionRedo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				controleur.notifierActionRedo();
				
			}});


    
		
		
		
		// choix theme1
		
		Button actionChoisirTheme1 = (Button) lookup("#action-choisir-theme1");
		actionChoisirTheme1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.out.println("Clic theme1 sombre");
				controleur.notifierChoixTheme(THEME.THEME1);
				
			}});
		
		
		
		//choix theme2
		Button actionChoisirTheme2 = (Button) lookup("#action-choisir-theme2");
		actionChoisirTheme2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.out.println("Clic theme2 clair");
				controleur.notifierChoixTheme(THEME.THEME2);
				
			}
			
		});
		
		
		//choix theme3
		
		Button actionChoisirTheme3 = (Button) lookup("#action-choisir-theme3");
		actionChoisirTheme3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.out.println("Clic theme3");
				controleur.notifierChoixTheme(THEME.THEME3);
				
			}
			
		});
		
		
		
		// choix theme4
		
		Button actionChoisirTheme4 = (Button) lookup("#action-choisir-theme4");
		actionChoisirTheme4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.out.println("Clic theme4 Perso2");
				controleur.notifierChoixTheme(THEME.THEME4);
				
			}});
		

		
		// choix fond1
		Button actionChoisirFond1 = (Button) lookup("#action-choisir-fond1");
		actionChoisirFond1.setOnAction(new SelecteurDeFond(controleur, Fond.FOND.FOND1));
				
		// choix fond2
		Button actionChoisirFond2 = (Button) lookup("#action-choisir-fond2");
		actionChoisirFond2.setOnAction(new SelecteurDeFond(controleur, Fond.FOND.FOND2));
				
				// choix fond3
		Button actionChoisirFond3 = (Button) lookup("#action-choisir-fond3");
		actionChoisirFond3.setOnAction(new SelecteurDeFond(controleur, Fond.FOND.FOND3));

				// choix fond4
		Button actionChoisirFond4 = (Button) lookup("#action-choisir-fond4");
		actionChoisirFond4.setOnAction(new SelecteurDeFond(controleur, Fond.FOND.FOND4));
	
		

		
		
		
		//Emoji dragon
		Button actionChoisirDragon = (Button) lookup("#action-choisir-dragon");
		actionChoisirDragon.setOnAction(new SelecteurEmoticon(controleur,Emoticon.EMOTICON.DRAGON));
		//Emoji fleur
		Button actionChoisirFleur = (Button) lookup("#action-choisir-fleur");
		actionChoisirFleur.setOnAction(new SelecteurEmoticon(controleur,Emoticon.EMOTICON.FLEUR));
		
		//Emoji Emoji
		Button actionChoisirEmoji = (Button) lookup("#action-choisir-emoji");
		actionChoisirEmoji.setOnAction(new SelecteurEmoticon(controleur,Emoticon.EMOTICON.EMOJI));
		
		//Emoji oiseau
		Button actionChoisirOiseau = (Button) lookup("#action-choisir-oiseau");
		actionChoisirOiseau.setOnAction(new SelecteurEmoticon(controleur,Emoticon.EMOTICON.OISEAU));
		
		//Emoji timbre
		Button actionChoisirTimbre = (Button) lookup("#action-choisir-timbre");
		actionChoisirTimbre.setOnAction(new SelecteurElement(controleur,Decoration.ELEMENT.TIMBRE));
		
		//Emoji soulier
		Button actionChoisirSoulier = (Button) lookup("#action-choisir-soulier");
		actionChoisirSoulier.setOnAction(new SelecteurElement(controleur,Decoration.ELEMENT.SOULIER));
		
		//Emoji tshirt
		Button actionChoisirTshirt = (Button) lookup("#action-choisir-tshirt");
		actionChoisirTshirt.setOnAction(new SelecteurElement(controleur,Decoration.ELEMENT.TSHIRT));
	
		
		//Emoji voeux
		Button actionChoisirVoeux = (Button) lookup("#action-choisir-voeux");
		actionChoisirVoeux.setOnAction(new SelecteurElement(controleur,Decoration.ELEMENT.VOEUX));
		
		
		Rectangle carte = (Rectangle) lookup("#fond-carte");
		carte.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				
				double x = e.getX();
				double y = e.getY();
				System.out.println("Clic carte "+ x +"-"+ y);
				controleur.notifierClicCarte(x, y);
				
			}});
		



		
	
		
		

	}

	public void afficherFond(FOND fondChoisi) {
		System.out.println("Fond : " + fondChoisi);
		AnchorPane carteContour = (AnchorPane)lookup("#carte-contour");
		String imgPath = imagesFond.get(fondChoisi);
		carteContour.setStyle("-fx-background-image:url('" + "vue/decoration/fond/" + imgPath + "')");
		
	}

	public void afficherItem(ELEMENT itemChoisi, double x, double y) {
		System.out.println("Element "+ itemChoisi + "est inséré à "+ x +"-"+y);
		ImageView itemInsere = new ImageView(new Image("vue/decoration/elements/" + itemChoisi.name().toLowerCase()+".png"));
		itemInsere.setPreserveRatio(true);
		itemInsere.setFitHeight(50);
		itemInsere.setX(x-15);
		itemInsere.setY(y-15);
		AnchorPane carteVue = (AnchorPane) lookup("#carte-contour");
		carteVue.getChildren().add(itemInsere);
		atLastVisuelItem.put(x + "-" + y, itemInsere);
	}
	
	public void afficherEmoticon(EMOTICON emoticonChoisi, double x, double y) {
		System.out.println("emoticon "+ emoticonChoisi + "est inséré à "+ x +"-"+y);
		ImageView emoticonInsere = new ImageView(new Image("vue/decoration/emoticon/" + emoticonChoisi.name().toLowerCase()+".png"));
		emoticonInsere.setPreserveRatio(true);
		emoticonInsere.setFitHeight(50);
		emoticonInsere.setX(x-15);
		emoticonInsere.setY(y-15);
		AnchorPane carteVue = (AnchorPane) lookup("#carte-contour");
		carteVue.getChildren().add(emoticonInsere);
		atLastVisuelEmoticon.put(x + "-" + y, emoticonInsere);
	}

	public void afficherTheme(THEME themeChoisi) {
		System.out.println("Theme : "+ themeChoisi);
		AnchorPane espaceTravail = (AnchorPane)lookup("#espace-travail");
		String imgPath = imagesTheme.get(themeChoisi);
		espaceTravail.setStyle("-fx-background-image:url('" + "vue/decoration/theme/" + imgPath + "')");
		
	}
	protected HashMap<String, ImageView> atLastVisuelItem = new HashMap<String, ImageView>();
	public void supprimerItem(ELEMENT itemChoisi, double x, double y) {
		ImageView itemSupprime = atLastVisuelItem.get(x + "-" + y);
		AnchorPane carteVue = (AnchorPane) lookup("#carte-contour");
		carteVue.getChildren().remove(itemSupprime);
		System.out.println("REMOVED: "+itemSupprime);
		
		
		
	}
	
	protected HashMap<String, ImageView> atLastVisuelEmoticon= new HashMap<String, ImageView>();
	public void supprimerEmoticon(EMOTICON emoticonChoisi, double x, double y) {
		ImageView emoticonSupprime = atLastVisuelEmoticon.get(x + "-" + y);
		AnchorPane carteVue = (AnchorPane) lookup("#carte-contour");
		carteVue.getChildren().remove(emoticonSupprime);
		System.out.println("REMOVED: "+emoticonSupprime);
		
	}


}



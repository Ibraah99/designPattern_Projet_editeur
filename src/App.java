
import architecture.Controleur;
import architecture.Fenetre;
import vue.VueCarteditor;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueCarteditor.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}

package vue.environnement;

import controleur.ControleurCarteditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.Fond;
import modele.Fond.FOND;

public class SelecteurDeFond implements EventHandler<ActionEvent>{
	
	protected ControleurCarteditor controleur;
	protected Fond.FOND fond ;
	
	

	public SelecteurDeFond(ControleurCarteditor controleur, FOND fond) {
		super();
		this.controleur = controleur;
		this.fond = fond;
	}



	@Override
	public void handle(ActionEvent e) {
		System.out.println("Clic fond :" + fond);
		controleur.notifierChoixFond(fond);
	}

}

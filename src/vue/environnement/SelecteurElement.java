package vue.environnement;

import controleur.ControleurCarteditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.Decoration;
import modele.Decoration.ELEMENT;

public class SelecteurElement implements EventHandler<ActionEvent>  {
	protected ControleurCarteditor controleur;
	protected Decoration.ELEMENT element;
	
	

	public SelecteurElement(ControleurCarteditor controleur, ELEMENT element) {
		super();
		this.controleur = controleur;
		this.element = element;
	}



	@Override
	public void handle(ActionEvent e) {
		System.out.println("Clic elemen : " + element);
		controleur.notifierChoixItem(element);	
		}

}

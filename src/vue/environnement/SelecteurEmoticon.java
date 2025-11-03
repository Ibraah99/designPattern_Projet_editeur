package vue.environnement;

import controleur.ControleurCarteditor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.Emoticon;
import modele.Emoticon.EMOTICON;



	
	public class SelecteurEmoticon implements EventHandler<ActionEvent>  {
		protected ControleurCarteditor controleur;
		protected Emoticon.EMOTICON emoticon;
		

		public SelecteurEmoticon(ControleurCarteditor controleur, EMOTICON emoticon) {
			super();
			this.controleur = controleur;
			this.emoticon = emoticon;
		}

		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Clic emoticon : " + emoticon);
			controleur.notifierChoixEmoticon(emoticon);	
			
		}

}

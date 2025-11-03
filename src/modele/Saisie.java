package modele;

import donnee.Exportable;

public class Saisie implements Exportable {
	
	protected String texte;
	
	public Saisie(String texte) {
		super();
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	@Override
	public String exporterXML() {
		return "<Texte>" + this.texte.toString() + "</Texte>";
	}

	@Override
	public String exporterJSON() {
		return "";
	}

}

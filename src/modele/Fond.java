package modele;

import donnee.Exportable;

public class Fond implements Exportable{
	
	public enum FOND{FOND1,FOND2,FOND3,FOND4}
	protected FOND fond;

	
	public Fond(FOND fondChoisi) {
		super();
		this.fond = fondChoisi;
	}



	public FOND getFond() {
		return fond;
	}
	public void setFond(FOND fond) {
		this.fond = fond;
	}



	@Override
	public String exporterXML() {
		return "\n<fond>" + this.fond.toString() + "</fond>\n";
	}



	@Override
	public String exporterJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

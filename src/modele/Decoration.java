package modele;

import donnee.Exportable;

public class Decoration implements Exportable
{
	
	public enum ELEMENT{TIMBRE,VOEUX,SOULIER,TSHIRT}
	protected ELEMENT element;
	protected double x;
	protected double y;
	
	public Decoration(ELEMENT element, double x, double y) {
		super();
		this.element = element;
		this.x = x;
		this.y = y;
	}
	public ELEMENT getElement() {
		return element;
	}

	public void setElement(ELEMENT element) {
		this.element = element;
	}
	@Override
	public String exporterXML() {
		String xml = "";
		xml += "<sorte>" + this.element.toString() + "</sorte>";
		xml += "<x>" + this.x + "</x>";
		xml += "<y>" + this.x + "</y>";
		return "\n<decoration>" + xml + "</decoration>\n";
	}
	@Override
	public String exporterJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
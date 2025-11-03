package modele;

import donnee.Exportable;

public class Emoticon implements Exportable
{
	
	public enum EMOTICON{DRAGON,FLEUR,EMOJI,OISEAU}
	protected EMOTICON emoticon;
	protected double x;
	protected double y;
	
	public Emoticon(EMOTICON emoticon, double x, double y) {
		super();
		this.emoticon = emoticon;
		this.x = x;
		this.y = y;
	}
	
	public EMOTICON getEmoticon() {
		return emoticon;
	}

	public void setEmoticon(EMOTICON emoticon) {
		this.emoticon = emoticon;
	}

	@Override
	public String exporterXML() {
		String xml = "";
		xml += "<sorte>" + this.emoticon.toString() + "</sorte>";
		xml += "<x>" + this.x + "</x>";
		xml += "<y>" + this.x + "</y>";
		return "\n<emoticon>" + xml + "</emoticon>\n";	}

	@Override
	public String exporterJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

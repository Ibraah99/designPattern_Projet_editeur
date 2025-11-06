package modele;

import java.util.ArrayList;
import java.util.List;

import donnee.Exportable;
import modele.Fond.FOND;

public class CarteDeSouhait implements Exportable {
	
	protected List<Decoration> elements = new ArrayList<Decoration>();
	//protected FOND fond;
	protected Fond fond  ;
	protected List<Emoticon> emoticons = new ArrayList<Emoticon>();
	protected Saisie saisie;
	protected String couleurHex = "#000000";


	
	
	public Fond getFond() {
	    if(fond == null) fond = new Fond(FOND.VIDE);
	    return fond;
			
	}
	public void ajouterElement(Decoration element)
	{
		this.elements.add(element);
	}
	public void ajouterEmoticon(Emoticon emoticon)
	{
		this.emoticons.add(emoticon);
	}


	public List<Decoration> getElements() {
		return elements;
	}

	public void setElements(List<Decoration> elements) {
		this.elements = elements;
	}


	public void setFond(Fond fond) {
		this.fond = fond;
	}


	public List<Emoticon> getEmoticon() {
		return emoticons;
	}


	public void setEmoticon(List<Emoticon> emoticons) {
		this.emoticons = emoticons;
	}
	public Saisie getSaisie() {
		return saisie;
	}

	public void setSaisie(Saisie saisie) {
		this.saisie = saisie;
	}

	public String getCouleurHex() 
	{ return couleurHex; }
	public void setCouleurHex(String couleurHex) 
	{ this.couleurHex = couleurHex; }


public String exporterXML() {
		
		String xml = "";

		if(null != this.fond) xml+=this.fond.exporterXML();
		for(Decoration element : this.elements)
		{
			xml += element.exporterXML();
		}
		for(Emoticon emoticon : this.emoticons)
		{
			xml += emoticon.exporterXML();
		}
		 
	    if (this.saisie != null) {
	        xml += "<saisie>\n<couleurHex>"+couleurHex+"</couleurHex>\n" + this.saisie.getTexte().toString() + "</saisie>\n";
	    } 
				
		return "\n<carteSouhait>" + xml + "</carteSouhait>\n";
	}

	@Override
	public String exporterJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

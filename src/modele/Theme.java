package modele;

public class Theme {
	
	public enum THEME{
		THEME1,THEME2,THEME3,THEME4
	}
	protected THEME theme;
	public Theme(THEME themeChoisi) {
		super();
		this.theme = themeChoisi;
	}

}

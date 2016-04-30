package Aula5;

public interface Policia {
	public enum Tipo{INEM, Bombeiros, GNR, PSP, PJ};
	public String getTipo(); 
	public String getID();
}

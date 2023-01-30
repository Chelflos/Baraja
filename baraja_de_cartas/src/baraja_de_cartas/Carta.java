package baraja_de_cartas;

public class Carta {
	int numero;
	String palo;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	
	public Carta(int numero, String palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}
	
	@Override
	public String toString() {
		return "Carta: "+ numero + " de " + palo + ".";
	}

	
	
}

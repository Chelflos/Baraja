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
	
	//Metodo para inicializar el array de cartas sin mostralo
	
	public static void iniciarArray(Carta[] cartas, String[] palos) {
		int num=0;
		String palo="";
		int n=0;
		for(int i = 0; i < cartas.length;i++) {
			Carta cartaActual=new Carta(num,palo);
			num++;
			if(num==7) num=9;
			if(num==8) num=10;
			cartaActual.setNumero(num);
			cartaActual.setPalo(palos[n]);
			cartas[i]=cartaActual;
			if(num==13) {
				num=1;
				n++;	
				cartaActual.setNumero(num);
				cartaActual.setPalo(palos[n]);
			}						
		}
	}
	
	/*-----------------------------Metodo para inicializar la lista con los valores del array sin mostrarlo--------------------------------------------------------------------------*/
	public static void iniciarLista(Carta[] cartas, List<Carta> barajada){
		List<Carta> convertirArray = Arrays.asList(cartas);
		barajada.clear();
		barajada.addAll(convertirArray);
	}
	
/*----------------------------------Metodo para volver a ordenar la baraja y borrar el monton----------------------------------------------------------------------*/
	
	public static void resetearBaraja(Carta[] cartas, String[] palos, List <Carta> monton) {
		int num=0;
		String palo="";
		int n=0;
		System.out.println("\nBaraja: \n");
		for(int i = 0; i < cartas.length;i++) {
			Carta cartaActual=new Carta(num,palo);
			num++;
			if(num==7) num=9;
			if(num==8) num=10;
			cartaActual.setNumero(num);
			cartaActual.setPalo(palos[n]);
			cartas[i]=cartaActual;
			if(num==13) {
				num=1;
				n++;	
				cartaActual.setNumero(num);
				cartaActual.setPalo(palos[n]);
			}			
			monton.clear();
			System.out.println(cartas[i]);			
		}
	}
	
/*----------------------------------Resetea la lista, rellena esta con los valores del array cartas, la desordena y muestra el resultado----------------------------------------------------------------------*/
	
	public static void barajar(Carta[] cartas, List<Carta> barajada){
		List<Carta> convertirArray = Arrays.asList(cartas);
		barajada.clear();
		barajada.addAll(convertirArray);
		Collections.shuffle(barajada);
	   System.out.println("\nBarajada: \n");
	   barajada.forEach(System.out::println);
	}
	
/*------------------------------------Saca carta, la elimina de la lista baraja y la anade a la de monton.En el caso de no quedar mas cartas que sacar, muestra un mensaje--------------------------------------------------------------------*/
	
	public static void sacarCarta(List<Carta> barajada, List<Carta> monton) {
		if(barajada.isEmpty()==false) {
		int ultimoIndex = barajada.size() -1;
		Carta ultimaCarta = barajada.get(ultimoIndex);		
		
		monton.add(ultimaCarta);
		barajada.remove(ultimoIndex);
		
		System.out.println("Se saca " + ultimaCarta);
		
		}else {
			System.out.println("\n---------------No quedan mas cartas. Barajee de nuevo.---------------");
		}	
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	
	public static void mostrarMonton(List <Carta> monton ){
		System.out.println("\nMonton: \n");
		for(int i = monton.size()-1;i>-1; i--) {
			System.out.println(monton.get(i));
		}
		//monton.forEach(System.out::println);
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

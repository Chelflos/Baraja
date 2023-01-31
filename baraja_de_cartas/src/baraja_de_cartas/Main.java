package baraja_de_cartas;
import java.util.*;
//Carlos Tenajas version para pruebas con git
public class Main {	
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
	private static void iniciarLista(Carta[] cartas, List<Carta> barajada){
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
	
	private static void barajar(Carta[] cartas, List<Carta> barajada){
		List<Carta> convertirArray = Arrays.asList(cartas);
		barajada.clear();
		barajada.addAll(convertirArray);
		Collections.shuffle(barajada);
	   System.out.println("\nBarajada: \n");
	   barajada.forEach(System.out::println);
	}
	
	
	/*------------------------------------Saca carta, la elimina de la lista baraja y la anade a la de monton.En el caso de no quedar mas cartas que sacar, muestra un mensaje--------------------------------------------------------------------*/
	
	private static void sacarCarta(List<Carta> barajada, List<Carta> monton) {
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
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String teclado;
		String[] palos = {"Copas","Bastos","Oros","Espadas"};
		Carta[] baraja = new Carta[40];
		List <Carta> monton = new ArrayList<>();
		List<Carta> barajada= new ArrayList<>();
		String n;
		
		
		iniciarArray(baraja, palos);				
		iniciarLista(baraja,barajada);	
		
		System.out.println("\n");
		System.out.println("Selecciona la accion a realizar: \n");		
			
		do {
				
			System.out.println("\n1.Reordenar baraja\n2.Barajar\n3.Sacar carta\n4.Sacar todas las cartas.\n5.Mostrar monton\n6.Salir.");
			teclado=sc.next();
			n=teclado;
			switch(teclado) {
				
				case "1":
					resetearBaraja(baraja, palos, monton);
					System.out.println("\n");
					break;
				case "2":		
					barajar(baraja,barajada);
					break;
				case "3":
					sacarCarta(barajada,monton);
					break;
				case "4":
					System.out.println("\n");
					System.out.println("Se saca carta:");
					for(int i = barajada.size()-1; i > -1;i--) sacarCarta(barajada,monton);
					break;
				case "5":
					mostrarMonton(monton);
					break;
				case "6":
					n="6";
					System.out.println("Hasta la proxima.");
				default:
					if(n!="6") {
					System.out.println("Dato erroneo. Por favor,  introduce un numero de entre los que se muestran: \n");
					}
					break;
				
			}
			
		}while(n!="6");
	}
}
	


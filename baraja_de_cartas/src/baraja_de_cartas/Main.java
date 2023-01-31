package baraja_de_cartas;
import java.util.*;
//Carlos Tenajas version para pruebas con git
public class Main {		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String teclado;
		String[] palos = {"Copas","Bastos","Oros","Espadas"};
		Carta[] baraja = new Carta[40];
		List <Carta> monton = new ArrayList<>();
		List<Carta> barajada= new ArrayList<>();
		String n;
		
		
		Carta.iniciarArray(baraja, palos);				
		Carta.iniciarLista(baraja,barajada);	
		
		System.out.println("\n");
		System.out.println("Selecciona la accion a realizar: \n");		
			
		do {
				
			System.out.println("\n1.Reordenar baraja\n2.Barajar\n3.Sacar carta\n4.Sacar todas las cartas.\n5.Mostrar monton\n6.Salir.");
			teclado=sc.next();
			n=teclado;
			
			switch(teclado) {
				
				case "1":
					Carta.resetearBaraja(baraja, palos, monton);
					System.out.println("\n");
					break;
				case "2":		
					Carta.barajar(baraja,barajada);
					break;
				case "3":
					Carta.sacarCarta(barajada,monton);
					break;
				case "4":
					System.out.println("\n");
					System.out.println("Se saca carta:");
					for(int i = barajada.size()-1; i > -1;i--) Carta.sacarCarta(barajada,monton);
					break;
				case "5":
					Carta.mostrarMonton(monton);
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
		sc.close();
	}
}
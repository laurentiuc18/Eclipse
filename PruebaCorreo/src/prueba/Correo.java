package prueba;

import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.Scanner;

public class Correo {

	public static String email;
	public static final int noError=0;
	public static final int Error1=1;
	public static final int Error2=2;
	public static final int Error3=3;
	public static final int Error4=4;
	public static final int Error5=5;
	public static final int Error6=6;
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa Correo");
		email =sc.nextLine();
		
		
	
		
		int comprueba=Comprobar(email);
		
		switch (comprueba) {
		case noError:
			System.out.println("Email Correcto");
			break;

		case Error1:
			System.out.println("'@' no encontrado");
			break;
		case Error2:
			System.out.println("'@' no puede estar en la 1ra posicion");
			break;
		case Error3:
			System.out.println("Tienen que haver mas de 4 caracteres antes del '@'");
			break;
		case Error4:
			System.out.println("no hay '.'");
			break;
		case Error5:
			System.out.println("Despues de '@' tiene que haver mas de 3 carac");
			break;
		case Error6:
			System.out.println("Dominio incorrecto, se debe elegir entre: (es,com,org,gov)");
			break;
		}	   
	}
	
	
	public static  int Comprobar(String email) {
		
		int count=email.indexOf('@');	
		
		if(count==-1) {return  Error1;}
		
		if(count==0) {return  Error2;}
		
		if(count<=4&&count>=1) {return  Error3;}
		
		
		String[] Separaren2 = email.split("@");
		int parte2=Separaren2[1].indexOf('.');
		
		if(parte2==-1) {return  Error4;}
		
		String[] dominio = Separaren2[1].split("\\.");
	
		if(parte2<3) {return  Error5; }

		
		switch (dominio[1]) {
		case "es":
			
			break;
		case "com":
			
			break;
		case "org":
	
			break;

		case "gov":
			
			break;
		default:
			return Error6;
		}
		
		return  noError;
		
		
		
	}

}

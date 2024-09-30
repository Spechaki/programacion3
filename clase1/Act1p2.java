package Clase01;

import java.math.BigInteger;

public class Act1p2 {
	public static void main(String[] args) {
		//Actividad 1.2
		
		//Long utiliza 8 bytes (-9,223,372,036,854,775,808 a 9,223,372,036,854,775,807) a
		//diferencia delint el cual utiliza 4 bytes (-2,147,483,648 a 2,147,483,647),
		//lo cual permite utilizarlo para operaciones grandes que no son posibles con int.
		//Por otro lado, BigInteger no tiene un limite de memoria, seguira ocupando espacio
		//segun sea necesario hasta que no haya mas memoria RAM en la pc.
		
		//Muestra la diferencia entre los limites de un int y un long
		
		int x = 2000000000;
		long y = 2000000000;
		
		BigInteger A  = new BigInteger("20000000000000000000000300000000000000500000000000000000");
		
		System.out.println(x+x + " Muestra el numero incorrecto porque el resultado supera el limite de int");

		System.out.println(y+y + " Muestra el numero correcto porque el resultado no supera el limite de long");

		System.out.println(A.add(A) + " BigInteger permite hacer calculos con numeros mucho mas grandes que int o long");	
	}
	
}

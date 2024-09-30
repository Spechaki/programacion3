package Clase4;

import java.util.Arrays;


public class Actividad1 {
	
	
	public boolean encontrarMinimoMonedas(int[] monedas, int monto) {
		 Arrays.sort(monedas);
		 for (int i = monedas.length - 1; i >= 0; i--) {
		 while (monto >= monedas[i]) {
			 monto -= monedas[i];
		 	}
		 }
		 return monto == 0;
	}


}

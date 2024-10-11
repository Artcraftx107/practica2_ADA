public class ProblemaInversiones {
	
	public static int numInversiones(int[] v) {
		return numInv(v,0,v.length-1);
	}
	
	private static int numInv(int[] a, int prim, int ult) {
		//Completar la implementación de este método
		int numInv = 0;

		/*Comprueba que no sea un array de un solo elemento,
		o que haya un error y que el valor de prim sea mayor al valor de ult*/
		if(prim<ult){
			int medio=(prim+ult)/2;

			//Dividimos y contamos las inversiones
			int inversionsIzq = numInv(a, prim, medio);
			int inversionesDerecha = numInv(a, medio+1, ult);

			//Juntamos las mitades y apuntamos las que son comunes
			int juntarInversiones = mezclarYContar(a, prim, medio, ult);

			/*
			El total es la suma de las inversiones en ambas mitades + las comunes en
			caso de cumplir la condicion del if
			 */
			numInv=juntarInversiones+inversionesDerecha+inversionsIzq;
		}

		return numInv;
		//En caso de que no se cumpla la condicion inicial, devuelve 0
	}

	private static int mezclarYContar(int[] a, int prim, int medio, int ult) {
		int[] temp = new int[ult - prim+1];
		int i = prim;
		int j = medio+1;
		int k=0;
		int inverisones = 0;

		//Juntar mitades y contar inversiones
		while(i<=medio && j<=ult){
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
				inverisones+=(medio-i + 1); //El resto de posiciones a la izquierda son todas inversiones
			}
		}

		//Copiar elementos restantes de la mitad izquierda
		while(i<=medio){
			temp[k++]=a[i++];
		}

		//Copiar elementos restantes de la mitad derecha
		while(j<=ult){
			temp[k++]=a[j++];
		}

		//Transferir elementos ordenados again al array original
		for(int e= 0; e<temp.length; e++){
			a[prim+e]=temp[e];
		}

		return inverisones;
	}
}

public class KesimoElemento {

	public static int buscarKesimo(int[] a, int k) {
		return buscarKesimo(a, k, 0, a.length - 1);
	}

	private static int buscarKesimo(int[] v, int k, int ini, int fin) {
		//Completar la implementación de este método
		int kesimo = 0;
		if(ini == fin){
			/*Si solo hay un elemento, lo devuelvo*/
			kesimo=v[fin];
		}else{
			//Elegimos un pivote y particionamos el array
			int pivote = partir(v, ini, fin);

			//Comparamos posicion del pivote con k
			if(pivote==k){
				kesimo=v[pivote];
			} else if (k<pivote) {
				kesimo=buscarKesimo(v, k, ini, pivote-1);
			} else {
				kesimo=buscarKesimo(v, k, pivote+1, fin);
			}
		}
		return kesimo;
	}

	private static int partir(int[] v, int ini, int fin) {
		int pivote = v[fin];
		int i = ini-1;

		for(int j = 0; j<fin; j++){
			if(v[j]<=pivote){
				i++;
				intercambiar(v, i, j);
			}
		}

		intercambiar(v, i+1,fin);
		return i+1;
	}

	private static void intercambiar(int[] v, int i, int j) {
		int temp = v[i];
		v[i]=v[j];
		v[j]=temp;
	}
}

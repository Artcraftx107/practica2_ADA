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

	public static int partir(int[] a, int inf, int sup) {
		int pivote = a[inf];
		int i = inf + 1;
		int j = sup;

		do {
			while ((i <= j) && (a[i] <= pivote)) {
				i++;
			}
			while ((i <= j) && (a[j] > pivote)) {
				j--;
			}
			if (i < j) {
				intercambiar(a, i, j);
			}
		} while (i <= j);

		intercambiar(a, inf, j);
		return j;
	}

	private static void intercambiar(int[] v, int i, int j) {
		int temp = v[i];
		v[i]=v[j];
		v[j]=temp;
	}
}

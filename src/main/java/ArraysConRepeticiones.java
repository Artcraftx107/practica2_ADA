public class ArraysConRepeticiones {

	//Precondición: hay un elemento repetido=> v.length >= 2
	public static int encuentraElem(int [] v) {
		return encuentraElem(v,0,v.length-1);
	}
	
	private static int encuentraElem(int [] v, int izq, int der) {
		//Completar la implementación del método
		int elem = -1;
		while (izq<=der){
			int mitad = izq+(der-izq)/2;

			//Devolver elemento repetido si lo encontramos (solo hay uno repetido n veces)
			if(mitad>0 && v[mitad]==v[mitad-1]){
				elem = v[mitad];
			} else {
				if (mitad < v.length - 1 && v[mitad] == v[mitad + 1]) {
					elem = v[mitad];
				}
			}

			if(v[mitad]-mitad>v[0]){
				der=mitad-1;
			}else{
				izq=mitad+1;
			}
		}
		return elem; 
	}
}

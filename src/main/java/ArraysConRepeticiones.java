public class ArraysConRepeticiones {

	// Precondición: hay un elemento repetido => v.length >= 2
	public static int encuentraElem(int[] v) {
		return encuentraElem(v, 0, v.length - 1);
	}

	private static int encuentraElem(int[] v, int izq, int der) {
		int elem = -1;
		while (izq <= der) {
			int mitad = izq + (der - izq) / 2;

			// Verificar si el elemento en mitad es el repetido
			if (mitad > 0 && v[mitad] == v[mitad - 1]) {
				elem = v[mitad];  // Si es igual al anterior, es el repetido
			}
			if (mitad < v.length - 1 && v[mitad] == v[mitad + 1]) {
				elem = v[mitad];  // Si es igual al siguiente, es el repetido
			}

			// Si no es el repetido, ajustar la búsqueda
			// Comprobamos el tamaño relativo de las mitades para decidir a dónde ir
			int elementosIzq = mitad - izq;  // Elementos a la izquierda de mitad
			int elementosDer = der - mitad;  // Elementos a la derecha de mitad

			// La mitad que no se ajusta a la secuencia esperada contiene el repetido
			if (elementosIzq > (v[mitad] - v[izq])) {
				// Si la izquierda tiene más elementos de lo que debería, vamos a la izquierda
				der = mitad - 1;
			} else {
				// Si no, vamos a la derecha
				izq = mitad + 1;
			}
		}

		return elem;  // No debería llegar aquí si la precondición es correcta
	}
}

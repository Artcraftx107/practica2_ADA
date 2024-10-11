public class ArraysConRepeticiones {

	// Precondición: hay un elemento repetido => v.length >= 2
	public static int encuentraElem(int[] v) {
		return encuentraElem(v, 0, v.length - 1);
	}

	private static int encuentraElem(int[] v, int izq, int der) {
		while (izq <= der) {
			int mitad = izq + (der - izq) / 2;

			// Comprobar si el elemento en mitad es el repetido
			if (mitad > 0 && v[mitad] == v[mitad - 1]) {
				return v[mitad];  // Si es igual al anterior
			}
			if (mitad < v.length - 1 && v[mitad] == v[mitad + 1]) {
				return v[mitad];  // Si es igual al siguiente
			}

			// Si no hemos encontrado el elemento repetido, ajustamos la búsqueda
			// Comparamos la diferencia entre índices para detectar la parte con el elemento repetido
			if (v[mitad] - mitad > v[0]) {
				// Si el desplazamiento es mayor que el esperado, el repetido está a la izquierda
				der = mitad - 1;
			} else {
				// Si no, está a la derecha
				izq = mitad + 1;
			}
		}

		return -1; // No debería llegar aquí si la precondición se cumple
	}
}

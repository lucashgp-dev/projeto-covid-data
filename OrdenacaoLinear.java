public class OrdenacaoLinear { // counting

	public OrdenacaoLinear() {
	}

	public String[][] countSort(String[][] array, int dados) {
		int tamanho = array.length;

		String[][] saida = new String[tamanho + 1][0];

		String[] max = array[1];
		for (int i = 1; i < tamanho; i++) {
			if (Integer.parseInt(array[i][dados]) > Integer.parseInt(max[dados]))
				max = array[i];
		}
		int[] cont = new int[Integer.parseInt(max[dados]) + 1];

		for (int i = 0; i < Integer.parseInt(max[dados]); ++i) {
			cont[i] = 0;
		}

		for (int i = 1; i < tamanho; i++) {
			cont[Integer.parseInt(array[i][dados])]++;
		}

		for (int i = 1; i <= Integer.parseInt(max[dados]); i++) {
			cont[i] += cont[i - 1];
		}

		for (int i = tamanho - 1; i > 0; i--) {
			saida[cont[Integer.parseInt(array[i][dados])] - 1] = array[i];
			cont[Integer.parseInt(array[i][dados])]--;
		}
		for (int i = 0; i < tamanho; i++) {
			array[i] = saida[i];
		}
		return array;

	}

}

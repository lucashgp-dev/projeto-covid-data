import java.text.Collator;

public class OrdenacaoRecursao {
	String[][] array = new String[5617][16];

	public OrdenacaoRecursao(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.arraycopy(array[i], 0, this.array[i], 0, 14);
		}
	}

	// merge
	private static void organizar(String[][] vetor, int primeiro, int meio, int ultimo, int dados) {
		String[][] array = new String[ultimo - primeiro][];
		Collator comparar = Collator.getInstance();
		comparar.setStrength(Collator.NO_DECOMPOSITION);
		int posicao = 0;
		int i = primeiro;
		int meioAux = meio;
		if (dados != 4) {
			while (i < meio && meioAux < ultimo) {
				if (Integer.parseInt(vetor[i][dados]) <= Integer.parseInt(vetor[meioAux][dados])) {
					array[posicao] = vetor[i];

					posicao++;
					i++;
				} else {
					array[posicao] = vetor[meioAux];

					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) {
				array[posicao] = vetor[meioAux];

				posicao++;
				meioAux++;
			}

			while (i < meio) {
				array[posicao] = vetor[i];

				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) {
				vetor[i] = array[posicao];
				posicao++;
			}
		} else {
			while (i < meio && meioAux < ultimo) {
				if (comparar.compare(vetor[meioAux][dados], vetor[i][dados]) > 0) {

					array[posicao] = vetor[i];

					posicao++;
					i++;

				} else {
					array[posicao] = vetor[meioAux];

					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) {
				array[posicao] = vetor[meioAux];

				posicao++;
				meioAux++;
			}

			while (i < meio) {
				array[posicao] = vetor[i];

				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) {
				vetor[i] = array[posicao];
				posicao++;
			}
		}
	}

	public String[][] mergeSort(String[][] vetor, int inicio, int fim, int dados) {

		if (inicio < fim - 1) {

			int meio = (inicio + fim) / 2;

			mergeSort(vetor, inicio, meio, dados);
			mergeSort(vetor, meio, fim, dados);
			organizar(vetor, inicio, meio, fim, dados);
		}
		return vetor;
	}

	// QuickSort

	public String[][] quickSort(String[][] array, int inicio, int fim, int dados) {
		if (dados != 4) {
			if (inicio < fim) {
				int pivo;
				pivo = Integer.parseInt(array[fim][dados]);

				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {

					if (Integer.parseInt(array[j][dados]) < pivo) {
						i++;
						String[] aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}

				}

				String[] aux = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = aux;
				int piAux = i + 1;

				quickSort(array, inicio, piAux - 1, dados);
				quickSort(array, piAux + 1, fim, dados);
				return array;
			}

		} else {
			Collator comparar = Collator.getInstance();
			comparar.setStrength(Collator.NO_DECOMPOSITION);
			if (inicio < fim) {
				String pivo = array[fim][dados];

				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {

					if (comparar.compare(pivo, array[j][dados]) > 0) {
						i++;
						String[] aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
				}
				String[] aux = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = aux;
				int piAux = i + 1;

				// Funcao recursiva para cada ramo da arvore
				quickSort(array, inicio, piAux - 1, dados);
				quickSort(array, piAux + 1, fim, dados);
			}

		}

		return array;
	}

	// Mediana de três

	public String[][] medianaDeTres(String[][] array, int primeiro, int ultimo, int dados) {
		if (dados != 4) {
			if (primeiro < ultimo) {

				int meio = ((primeiro + ultimo) / 2);
				int a = Integer.parseInt(array[primeiro][dados]);
				int b = Integer.parseInt(array[meio][dados]);
				int c = Integer.parseInt(array[ultimo][dados]);
				int medianaIndice;

				if (a < b) {
					if (b < c) {

						medianaIndice = meio;
					} else {
						if (a < c) {

							medianaIndice = ultimo;
						} else {

							medianaIndice = primeiro;
						}
					}
				} else {
					if (c < b) {

						medianaIndice = meio;
					} else {
						if (c < a) {

							medianaIndice = ultimo;
						} else {

							medianaIndice = primeiro;
						}
					}
				}

				swap(array, medianaIndice, ultimo);

				int pivo = Integer.parseInt(array[ultimo][dados]);

				int i = (primeiro - 1);
				for (int j = primeiro; j <= ultimo - 1; j++) {

					if (Integer.parseInt(array[j][dados]) < pivo) {
						i++;
						String[] aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
				}

				String[] aux = array[i + 1];
				array[i + 1] = array[ultimo];
				array[ultimo] = aux;
				int piAux = i + 1;

				medianaDeTres(array, primeiro, piAux - 1, dados);
				medianaDeTres(array, piAux + 1, ultimo, dados);
			}
		} else {
			if (primeiro < ultimo) {
				Collator comparar = Collator.getInstance();
				comparar.setStrength(Collator.NO_DECOMPOSITION);
				int meio = ((primeiro + ultimo) / 2);
				String a = (array[primeiro][dados]);
				String b = (array[meio][dados]);
				String c = (array[ultimo][dados]);
				int medianaIndice;

				if (comparar.compare(b, a) > 0) {
					if (comparar.compare(c, b) > 0) {

						medianaIndice = meio;
					} else {
						if (comparar.compare(c, a) > 0) {

							medianaIndice = ultimo;
						} else {

							medianaIndice = primeiro;
						}
					}
				} else {
					if (comparar.compare(b, c) > 0) {

						medianaIndice = meio;
					} else {
						if (comparar.compare(a, c) > 0) {

							medianaIndice = ultimo;
						} else {

							medianaIndice = primeiro;
						}
					}
				}

				swap(array, medianaIndice, ultimo);

				String pivo = (array[ultimo][dados]);

				int i = (primeiro - 1);
				for (int j = primeiro; j <= ultimo - 1; j++) {

					if (comparar.compare(pivo, array[j][dados]) > 0) {
						i++;
						String[] aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
				}

				String[] aux = array[i + 1];
				array[i + 1] = array[ultimo];
				array[ultimo] = aux;
				int piAux = i + 1;

				medianaDeTres(array, primeiro, piAux - 1, dados);
				medianaDeTres(array, piAux + 1, ultimo, dados);
			}
		}
		return array;
	}

	public static void swap(String[][] A, int i, int j) {
		String[] temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// HeapSort

	public String[][] sort(String[][] array, int dados) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 1; i--)
			heapify(array, n, i, dados);

		for (int i = n - 1; i > 1; i--) {

			String[] temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0, dados);
		}

		return array;
	}

	static void heapify(String[][] array, int n, int i, int dados) {
		if (dados != 4) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if (l < n && Integer.parseInt(array[l][dados]) > Integer.parseInt(array[largest][dados]))
				largest = l;

			if (r < n && Integer.parseInt(array[r][dados]) > Integer.parseInt(array[largest][dados]))
				largest = r;

			if (largest != i) {
				String[] swap = array[i];
				array[i] = array[largest];
				array[largest] = swap;

				heapify(array, n, largest, dados);
			}
		} else {
			Collator comparar = Collator.getInstance();
			comparar.setStrength(Collator.NO_DECOMPOSITION);
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if (l < n && comparar.compare(array[l][dados], array[largest][dados]) > 0)
				largest = l;

			if (r < n && comparar.compare(array[r][dados], array[largest][dados]) > 0)
				largest = r;

			if (largest != i) {
				String[] swap = array[i];
				array[i] = array[largest];
				array[largest] = swap;

				// Funcao recursiva para cada ramo da arvore
				heapify(array, n, largest, dados);
			}
		}

	}
}

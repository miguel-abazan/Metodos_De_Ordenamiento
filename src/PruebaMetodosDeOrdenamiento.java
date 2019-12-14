import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class MetodosOrdenamiento {

	long t = 0;
	long c = 0;
	long in = 0;
	long r = 0;

	public void ordenamientoBurbuja1(int arr[]) {
		t = System.nanoTime();
		
		
		for (int i = 1; i < arr.length; i++) {
			r++;
			for (int j = 0; j < arr.length - i; j++) {
				r++;
				c++;
				if (arr[j] > arr[j + 1]) {
					int aux = arr[j];
					in++;
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}
		}
		
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));

	}

	public void ordenamientoBurbuja2(int[] arr) {
		t = System.nanoTime();
		
		int i = 1;
		boolean ordenado = false;
		while ((i < arr.length) || (ordenado == false)) {

			i = i + 1;
			ordenado = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {

					ordenado = false;
					in ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;

				}
			}

		}
	System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	
	
	public void ordenamientoBurbuja3(int[] arr) {
		t = System.nanoTime();

		int i = 1;
		boolean ordenado = true;
		do {
			i = i + 1;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					ordenado = false;
					in ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}

		} while (i < arr.length || ordenado == true);
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// ShellSort ////////////////////

	public int shellSort(int arr[]) {
		t = System.nanoTime();
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			r++;
			for (int i = gap; i < n; i += 1) {
				r++;
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					r++;
					in ++;
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
		return 0;
	}

	//////// Intercalación //////////////////

	public void intercalacion(int[] arregloA, int[] arregloB) {
		t = System.nanoTime();
		int i, j, k;
		int arregloC[] = new int[arregloA.length + arregloB.length];
		// Repetir minetras los arreglos A y B tengan elementos a comparar
		for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
			r++;
			c++;
			if (arregloA[i] < arregloB[j]) {
				in++;
				arregloC[k] = arregloA[i];
				i++;

			} else {
				in++;
				arregloC[k] = arregloB[j];
				j++;
			}

		}

		// Añadir sobrantes del arreglo A en caso de haberlos
		for (; i < arregloA.length; i++, k++) {
			r++;
			in++;
			arregloC[k] = arregloA[i];
		}
		// Añadir sobrantes del arreglo B en caso de haberlos

		for (; j < arregloB.length; j++, k++) {
			r++;
			in ++;
			arregloC[k] = arregloA[j];
		}
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// RadixSort //////////////////////

	public void radixSort(int arr[]) {
		t = System.nanoTime();
		
		int x, i, j;
		for (x = Integer.SIZE - 1; x >= 0; x--) {
			r++;
			int aux[] = new int[arr.length];
			j = 0;
			for (i = 0; i < arr.length; i++) {
				r++;

				boolean mover = arr[i] << x > 0;

				c++;
				if (x == 0 ? !mover : mover) {
					in ++;
					aux[j] = arr[i];
					j++;

				} else {
					in ++;
					arr[i - j] = arr[i];

				}

			}
			for (i = j; i < aux.length; i++) {
				r++;
				in ++;
				aux[i] = arr[i] - j;
			}

			arr = aux;

		}
	System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// Mezcla Directa /////////////

	public int[] mezclaDirecta(int[] arreglo) {

		int i, j, k;

		c++;
		if (arreglo.length > 1) {

			int nElementosIzq = arreglo.length / 2;
			int nElementosDer = arreglo.length - nElementosIzq;
			int arregloIzq[] = new int[nElementosIzq];
			int arregloDer[] = new int[nElementosDer];

			// Cepiando los elementos al primer arreglo
			for (i = 0; i < nElementosIzq; i++) {
				in++;
				r++;
				arregloIzq[i] = arreglo[i];

			}
			// Copiando los elementos al segundo arreglo
			for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
				in++;
				r++;
				arregloDer[i - nElementosIzq] = arreglo[i];

			}
			// Recursividad
			arregloIzq = mezclaDirecta(arregloIzq);
			arregloDer = mezclaDirecta(arregloDer);

			i = 0;
			j = 0;
			k = 0;

			while (arregloIzq.length != j && arregloDer.length != k) {
				r++;
				c++;
				if (arregloIzq[j] < arregloDer[k]) {
					in++;
					arreglo[i] = arregloIzq[j];
					i++;
					j++;

				} else {
					arreglo[i] = arregloDer[k];
					in++;
					i++;
					k++;

				}

			}
			// Arreglo final
			while (arregloIzq.length != j) {
				r++;
				in++;
				arreglo[i] = arregloIzq[j];
				i++;
				j++;

			}
			while (arregloDer.length != k) {
				r++;
				in++;
				arreglo[i] = arregloDer[k];
				i++;
				k++;

			}
		} // fin del c++; if

		return arreglo;
	}

	//////// Quick Sort////////////////////

	public void quickSort(int arr[], int menor, int mayor) {
		c++;
		if (menor < mayor) {

			int pi = particion(arr, menor, mayor);

			quickSort(arr, menor, pi - 1);
			quickSort(arr, pi + 1, mayor);
		}
	}

	public int particion(int arr[], int menor, int mayor) {
		int pivot = arr[mayor];
		int i = (menor - 1);

		for (int j = menor; j < mayor; j++) {
			r++;
			c++;
			if (arr[j] < pivot) {
				i++;
				in ++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		int temp = arr[i + 1];
		in++;
		arr[i + 1] = arr[mayor];
		arr[mayor] = temp;

		return i + 1;
	}

	// Mezcla Natural /////////////////////
	
	public void Mezclanatural(int[] arreglo) {
		int izquierda=0,izq=0,derecha=arreglo.length-1,der=derecha;
		boolean ordenado=false;
		do {
			ordenado=true;
			izquierda=0;
			while (izquierda<derecha){
				izq=izquierda;
				while(izq<derecha&&arreglo[izq]<=arreglo[izq+1]) {
					izq++;
				}
				der=izq+1;
				while(der==derecha-1||der<derecha&&arreglo[der]<=arreglo[der+1]) {
					der++;	
				}
				if (der<=derecha) {
					mezclaDirecta2(arreglo);
					ordenado=false;
				}
				izquierda=izq;
				
			}
		}while(!ordenado);
		
		}
	
	public void mezclaDirecta2(int[] arreglo) {
		int i,j,k;
		if (arreglo.length>1) {
			int nElementosIzq=arreglo.length/2;
			int nElementosDer=arreglo.length-nElementosIzq;
			int arregloIzq[]=new int [nElementosIzq];
			int arregloDer[]=new int [nElementosDer];
			for (i = 0; i < nElementosIzq; i++) {
				arregloIzq[i]=arreglo[i];
			}
			for (i = nElementosIzq; i < nElementosIzq+nElementosDer; i++) {
				arregloDer[i-nElementosIzq]=arreglo[i];
			}
			arregloIzq=mezclaDirecta(arregloIzq);
			arregloDer=mezclaDirecta(arregloDer);
			i=0;
			j=0;
			k=0;
			while(arregloIzq.length!=j&&arregloDer.length!=k) {
				if(arregloIzq[j]<arregloDer[k]) {
					arreglo[i]=arregloIzq[j];
					i++;
					j++;
				}else {
					arreglo[i]=arregloDer[k];
					i++;
					k++;
				}
			}
			while(arregloIzq.length!=j) {
				arreglo[i]=arregloIzq[j];
				i++;
				j++;
			}
			while(arregloDer.length!=k) {
				arreglo[i]=arregloDer[k];
				i++;
				k++;
			}
		}
	}
	
	
}

class MetodosBusqueda{

	long t = 0; 
	long c = 0;
	long in = 0;
	long r = 0;
	int busquedaBinaria(int vector[], int posicionIzq, int posicionDer, int elementoA_Buscar) { 
		t = System.nanoTime();     
		for (int i = 0; i < vector.length; i++) {
			r++;
		}
		for (int i = 0; i < vector.length; i++) {
		in++;
		if (posicionDer >= posicionIzq) { 
	            int mitad = posicionIzq + (posicionDer - posicionIzq) / 2; 
	            
	            if (vector[mitad] == elementoA_Buscar) 
	                return mitad; 
	            
	            if (vector[mitad] > elementoA_Buscar) 
	                return busquedaBinaria(vector, posicionIzq, mitad - 1, elementoA_Buscar); 
	            
	            return busquedaBinaria(vector, mitad + 1, posicionDer, elementoA_Buscar); 
	        }
	}
		c++;
	        
	        return -1;
	
	        
	   }
	public  int busquedaSecuencial(int []arreglo,int dato){
		t = System.nanoTime(); 
		for (int i = 0; i < arreglo.length; i++) {
			r++;
		}
		
		int posicion = -1;
		  for(int i = 0; i < arreglo.length; i++){
		      if(arreglo[i] == dato){
		    posicion = i;
		    break;//
		   }
		      in++;
		 }c++;
		return posicion;
	}
	

}


public class PruebaMetodosDeOrdenamiento {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		boolean a = true;
		MetodosOrdenamiento ob = new MetodosOrdenamiento();
		Random r = new Random();
		
			System.out.println("Prueba De Ordenamiento(llenar vector con: \n1)1000\n2)10000\n3)100000\n4)1000000");
			byte opc=e.nextByte();
			switch (opc) {
			case 1:
				int arr[] = new int[1000];
				
				for (int i = 0; i < arr.length; i++) {

					arr[i] = r.nextInt(100);
				}
				int n = arr.length;
				int ar[] = Arrays.copyOf(arr, arr.length);
				MetodosBusqueda mo = new MetodosBusqueda();
				
				
				do {
					ob.c = 0;
					ob.in = 0;
					ob.r = 0;
					ob.t = 0;
					mo.t = 0;
					mo.in = 0;
					mo.r = 0;
					mo.c = 0;
					
					
					arr = Arrays.copyOf(ar, ar.length);
					System.out.println("Seleccione un metodo de ordenamiento");
					System.out.println("1.- Metodo Burbuja");
					System.out.println("2.- Metodo QuickSort");
					System.out.println("3.- Metodo ShellSort");
					System.out.println("4.- Metodo RadixSort");
					System.out.println("5.- Metodo Intercalacion");
					System.out.println("6.- Metodo Mezcla directa");
					System.out.println("7.- Metodo Mezcla natural");
					byte op = e.nextByte();
					switch (op) {
					case 1:
						System.out.println("Ordenando por el metodo Burbuja");

						ob.ordenamientoBurbuja1(arr);

						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						break;
					case 2:
						System.out.println("Ordenando por el metodo QuickSort");
						ob.t = System.nanoTime();
						ob.quickSort(arr, 0, n - 1);
						System.out.println("Arreglo ordenado"+arr.length);
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 3:
						System.out.println("Ordenando por el metodo ShellSort");
						ob.shellSort(arr);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 4:
						System.out.println("Ordenando por el metodo Radix");
						ob.radixSort(arr);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 5:
						System.out.println("Ordenando por el metodo Intercalacion");
						ob.intercalacion(arr, arr);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 6:
						System.out.println("Ordenando por el metodo Mezcla Directa");
						ob.t = System.nanoTime();
						ob.mezclaDirecta(arr);
						System.out.println("Arreglo ordenado");
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 7:
						System.out.println("Ordenando por el metodo Mezcla natural");
						ob.t = System.nanoTime();
						ob.Mezclanatural(arr);
						System.out.println("Arreglo ordenado");
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 8:
						System.out.println("Saliendo");
						a = false;
						break;

					default:
						break;
					}


					System.out.println();
					
					
				} while (a);
				e.close();
				break;
			case 2:
                int vec2[] = new int[10000];
				
				for (int i = 0; i < vec2.length; i++) {

					vec2[i] = r.nextInt(100);
				}
				int n1 = vec2.length;
				int ar1[] = Arrays.copyOf(vec2, vec2.length);
				MetodosBusqueda o = new MetodosBusqueda();
				
				
				do {
					ob.c = 0;
					ob.in = 0;
					ob.r = 0;
					ob.t = 0;
					o.t = 0;
					o.in = 0;
					o.r = 0;
					o.c = 0;
					
					
					vec2 = Arrays.copyOf(ar1, ar1.length);
					System.out.println("Seleccione un metodo de ordenamiento");
					System.out.println("1.- Metodo Burbuja");
					System.out.println("2.- Metodo QuickSort");
					System.out.println("3.- Metodo ShellSort");
					System.out.println("4.- Metodo RadixSort");
					System.out.println("5.- Metodo Intercalacion");
					System.out.println("6.- Metodo Mezcla directa");
					System.out.println("7.- Metodo Mezcla natural");
					byte op = e.nextByte();
					switch (op) {
					case 1:
						System.out.println("Ordenando por el metodo Burbuja");

						ob.ordenamientoBurbuja1(vec2);

						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						break;
					case 2:
						System.out.println("Ordenando por el metodo QuickSort");
						ob.t = System.nanoTime();
						ob.quickSort(vec2, 0, n1 - 1);
						System.out.println("Arreglo ordenado"+vec2.length);
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 3:
						System.out.println("Ordenando por el metodo ShellSort");
						ob.shellSort(vec2);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 4:
						System.out.println("Ordenando por el metodo Radix");
						ob.radixSort(vec2);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 5:
						System.out.println("Ordenando por el metodo Intercalacion");
						ob.intercalacion(vec2, vec2);
						System.out.println("Arreglo ordenado");
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 6:
						System.out.println("Ordenando por el metodo Mezcla Directa");
						ob.t = System.nanoTime();
						ob.mezclaDirecta(vec2);
						System.out.println("Arreglo ordenado");
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 7:
						System.out.println("Ordenando por el metodo Mezcla natural");
						ob.t = System.nanoTime();
						ob.Mezclanatural(vec2);
						System.out.println("Arreglo ordenado");
						System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
						System.out.println("Comparaciones: " + ob.c);
						System.out.println("Recorridos: " + ob.r);
						System.out.println("Intercambios: " + ob.in);
						// System.out.println(Arrays.toString(arr));
						break;
					case 8:
						System.out.println("Saliendo");
						a = false;
						break;

					default:
						break;
					}


					System.out.println();
					
					
				} while (a);
				e.close();
				break;
			case 3:
				 int vec3[] = new int[100000];
					
					for (int i = 0; i < vec3.length; i++) {

						vec3[i] = r.nextInt(100);
					}
					int n2 = vec3.length;
					int ar2[] = Arrays.copyOf(vec3, vec3.length);
					MetodosBusqueda so = new MetodosBusqueda();
					
					
					do {
						ob.c = 0;
						ob.in = 0;
						ob.r = 0;
						ob.t = 0;
						so.t = 0;
						so.in = 0;
						so.r = 0;
						so.c = 0;
						
						
						vec3 = Arrays.copyOf(ar2, ar2.length);
						System.out.println("Seleccione un metodo de ordenamiento");
						System.out.println("1.- Metodo Burbuja");
						System.out.println("2.- Metodo QuickSort");
						System.out.println("3.- Metodo ShellSort");
						System.out.println("4.- Metodo RadixSort");
						System.out.println("5.- Metodo Intercalacion");
						System.out.println("6.- Metodo Mezcla directa");
						System.out.println("7.- Metodo Mezcla natural");
						byte op = e.nextByte();
						switch (op) {
						case 1:
							System.out.println("Ordenando por el metodo Burbuja");

							ob.ordenamientoBurbuja1(vec3);

							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							break;
						case 2:
							System.out.println("Ordenando por el metodo QuickSort");
							ob.t = System.nanoTime();
							ob.quickSort(vec3, 0, n2 - 1);
							System.out.println("Arreglo ordenado"+vec3.length);
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 3:
							System.out.println("Ordenando por el metodo ShellSort");
							ob.shellSort(vec3);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 4:
							System.out.println("Ordenando por el metodo Radix");
							ob.radixSort(vec3);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 5:
							System.out.println("Ordenando por el metodo Intercalacion");
							ob.intercalacion(vec3, vec3);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 6:
							System.out.println("Ordenando por el metodo Mezcla Directa");
							ob.t = System.nanoTime();
							ob.mezclaDirecta(vec3);
							System.out.println("Arreglo ordenado");
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 7:
							System.out.println("Ordenando por el metodo Mezcla natural");
							ob.t = System.nanoTime();
							ob.Mezclanatural(vec3);
							System.out.println("Arreglo ordenado");
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 8:
							System.out.println("Saliendo");
							a = false;
							break;

						default:
							break;
						}


						System.out.println();
						
						
					} while (a);
					e.close();
				break;
			case 4:
				 int vec4[] = new int[1000000];
					
					for (int i = 0; i < vec4.length; i++) {

						vec4[i] = r.nextInt(100);
					}
					int n3 = vec4.length;
					int ar4[] = Arrays.copyOf(vec4, vec4.length);
					MetodosBusqueda solo = new MetodosBusqueda();
					
					
					do {
						ob.c = 0;
						ob.in = 0;
						ob.r = 0;
						ob.t = 0;
						solo.t = 0;
						solo.in = 0;
						solo.r = 0;
						solo.c = 0;
						
						
						vec3 = Arrays.copyOf(ar4, ar4.length);
						System.out.println("Seleccione un metodo de ordenamiento");
						System.out.println("1.- Metodo Burbuja");
						System.out.println("2.- Metodo QuickSort");
						System.out.println("3.- Metodo ShellSort");
						System.out.println("4.- Metodo RadixSort");
						System.out.println("5.- Metodo Intercalacion");
						System.out.println("6.- Metodo Mezcla directa");
						System.out.println("7.- Metodo Mezcla natural");
						byte op = e.nextByte();
						switch (op) {
						case 1:
							System.out.println("Ordenando por el metodo Burbuja");

							ob.ordenamientoBurbuja1(vec4);

							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							break;
						case 2:
							System.out.println("Ordenando por el metodo QuickSort");
							ob.t = System.nanoTime();
							ob.quickSort(vec4, 0, n3 - 1);
							System.out.println("Arreglo ordenado"+vec4.length);
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 3:
							System.out.println("Ordenando por el metodo ShellSort");
							ob.shellSort(vec4);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 4:
							System.out.println("Ordenando por el metodo Radix");
							ob.radixSort(vec4);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 5:
							System.out.println("Ordenando por el metodo Intercalacion");
							ob.intercalacion(vec4, vec4);
							System.out.println("Arreglo ordenado");
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 6:
							System.out.println("Ordenando por el metodo Mezcla Directa");
							ob.t = System.nanoTime();
							ob.mezclaDirecta(vec4);
							System.out.println("Arreglo ordenado");
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 7:
							System.out.println("Ordenando por el metodo Mezcla natural");
							ob.t = System.nanoTime();
							ob.Mezclanatural(vec4);
							System.out.println("Arreglo ordenado");
							System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
							System.out.println("Comparaciones: " + ob.c);
							System.out.println("Recorridos: " + ob.r);
							System.out.println("Intercambios: " + ob.in);
							// System.out.println(Arrays.toString(arr));
							break;
						case 8:
							System.out.println("Saliendo");
							a = false;
							break;

						default:
							break;
						}


						System.out.println();
						
						
					} while (a);
					e.close();
				break;
			default:
				break;
			}
		
		
		
	}

}
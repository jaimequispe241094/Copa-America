package Negocio;

import java.util.Iterator;

public class IteratorLista<T> implements Iterator<T> {

	private int posicionLista;
	private Lista<T> lista;
	
	 public IteratorLista(Lista<T> lista) {
		this.lista = lista; 
		this.posicionLista = 0;
	}
	
	@Override
	public boolean hasNext() {
		boolean ret = false;
		if (posicionLista < lista.tamaño()) {			//sobreescribe el hasnext el indice llevado en un contador y el tamaño de mi lista
			ret = true;
		}
		return ret;
	}

	@Override
	public T next() {								//se duevuelve el siguiente objeto de la lista , siempre que se respete el indice
		return lista.iesimo(posicionLista++); 
	}

}

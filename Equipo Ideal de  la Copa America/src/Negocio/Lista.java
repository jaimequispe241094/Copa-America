package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista<T> implements Iterable<T> {
	
	private ArrayList<T> miLista;
	
	public Lista() {
		miLista = new ArrayList<T>();
	}
	
	public void agregar(T objetoT){
		this.miLista.add(objetoT);
	}
	
	public T iesimo(int indice){
		return this.miLista.get(indice);
	}
	
	public int tamaño(){
		return miLista.size();
	}
	
	public boolean loContiene(T objetoT){
		boolean ret=false;
		for (T t : this) {
			ret = ret || objetoT.equals(t);
		}
		return ret;
	}
	
	public void eliminar(T objetoT){
		for (T t : this)
		{
			if(t.equals(objetoT))
			{		miLista.remove(t);		}
		}
	}
	
	public void union(Lista<T> lista){
		for(int i = 0; i<lista.tamaño(); i++)
		{
			agregar(lista.iesimo(i));
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> getLista(){
		return (ArrayList<T>) miLista.clone();
	}
	
	public void setLista(ArrayList<T> otro){
		this.miLista = otro;
	}
	
	@Override
	public Iterator<T> iterator() {
		 return new IteratorLista<T>(this);  
	}
	
	@Override
	public String toString() {
		String s = " ";
		for (int i = 0; i < tamaño(); i++) {
			s=s+iesimo(i).toString()+" "+"\n";
		}
		return "["+s+"\n"+"]";
	}
}

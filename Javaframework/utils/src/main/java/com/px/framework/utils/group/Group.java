package com.px.framework.utils.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Group is collection of related items.
 * for eg: a list of Flights.
 * 
 * @author 61008
 *
 * @param <T> Any class
 */
public class Group<T> implements Serializable,Iterable<T> {

	/**
	 * why i didn't use ArrayList? why didn't i just extend from ArrayList? No specific reason. i just felt like doing this way
	 */
	private static final long serialVersionUID = 7141307157844573818L;
	
	private transient List<T> items; 
	private String key;

	@Override
	public Iterator<T> iterator() {
		return items.iterator();
	}
	public void add(T item){
		if(items==null)
			items = new ArrayList<>();
		items.add(item);
	}
	public void addAll(List<T> items){
		if(this.items==null)
			this.items = new ArrayList<>();
		this.items.addAll(items);
	}
	public boolean isEmpty(){
		if(items!=null && !items.isEmpty())
		{
			return false;
		}
		return true;
	}
	public boolean contains(T item){
		if(items!=null && items.contains(item))
		{
			return true;
		}
		return false;
	}
	public int size(){
		return items.size();
	}
	public void remove(T item){
		items.remove(item);
	}
	public void removeAll(List<T> item){
		items.removeAll(item);
	}
	@Override
	public String toString() {
		return "Group [items=" + items + "]";
	}
	public T get(int index){
		return items.get(index);
	}
	public List<T> getAll(){
		return items;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}

package com.px.framework.utils.filter;

import java.util.ArrayList;
import java.util.List;




public class ListFilter<T> {
	private List<Filter<T>> filters; 
	
	public List<T> filter(List<T> items){
		List<T> filtereditems = new ArrayList<>();
		for(T item:items){
			if(filter(item)!=null)
				filtereditems.add(item);
		}
		return filtereditems;
	}
	
	public T filter(T item){
		if(filters!=null){
		for(Filter<T> filter:filters){ 
			if(!filter.check(item)){
				return null;
			}
		}
		}
		return item;
	}

	public List<Filter<T>> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter<T>> filters) {
		this.filters = filters;
	}
}

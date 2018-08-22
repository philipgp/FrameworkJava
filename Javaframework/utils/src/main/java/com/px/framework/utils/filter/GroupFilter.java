package com.px.framework.utils.filter;

import java.util.List;

import com.px.framework.utils.group.Group;





public class GroupFilter<T> {
	private List<Filter<T>> filters; 
	
	public Group<T> filter(Group<T> items){
		Group<T> filtereditems = new Group<>();
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

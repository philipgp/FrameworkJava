
package com.px.framework.utils.filter;
import java.util.ArrayList;
import java.util.List;

public class ListFilterBuilder<T> {
	private List<Filter<T>> filters;
	public ListFilterBuilder<T> addFilter(Filter<T> filter){
		if(filters == null)
			filters = new ArrayList<>();
		filters.add(filter);
		return this;
	}
	
	public ListFilter<T> build(){
		ListFilter<T> listFilter = new ListFilter<>();
		listFilter.setFilters(filters);
		return listFilter;
	}
}

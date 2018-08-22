
package com.px.framework.utils.filter;
import java.util.ArrayList;
import java.util.List;

public class GroupFilterBuilder<T> {
	private List<Filter<T>> filters;
	public GroupFilterBuilder<T> addFilter(Filter<T> filter){
		if(filters == null)
			filters = new ArrayList<>();
		filters.add(filter);
		return this;
	}
	
	public GroupFilter<T> build(){
		GroupFilter<T> listFilter = new GroupFilter<>();
		listFilter.setFilters(filters);
		return listFilter;
	}
}

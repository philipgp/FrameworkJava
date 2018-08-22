package com.px.framework.utils.filter;


public interface Filter<T> {
	public boolean check(T item);
}

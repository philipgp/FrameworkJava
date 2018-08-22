package com.px.framework.utils.filter;

@FunctionalInterface
public interface Filter<T> {
	public boolean check(T item);
}

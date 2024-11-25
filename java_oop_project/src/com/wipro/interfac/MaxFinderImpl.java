package com.wipro.interfac;

public class MaxFinderImpl implements MaxFinder {

	@Override
	public int maximum(int a, int b) {
		
		return (a>b)?a:b;
	}

}

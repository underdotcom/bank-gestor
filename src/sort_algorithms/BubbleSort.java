package sort_algorithms;

import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> implements Sort<T>{

	@Override
	public void sortAscending(T[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					swapArray(array, j, j+1);
				}
			}
		}
	}
	
	@Override
	public void sortDescending(T[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].compareTo(array[j + 1]) < 0) {
					swapArray(array, j, j+1);
				}
			}
		}
	}

	private void swapArray(T[] array, int a, int b) {
		T value = array[b];
		array[b] = array[a];
		array[a] = value;
	}
	
	@Override
	public void sortAscending(ArrayList<T> list) {
		for (int i = list.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					swapList(list, j, j+1);
				}
			}
		}
	}
	
	@Override
	public void sortDescending(ArrayList<T> list) {
		for (int i = list.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) < 0) {
					swapList(list, j, j+1);
				}
			}
		}
	}

	private void swapList(ArrayList<T> list, int a, int b) {
		T value = list.get(b);
		list.set(b, list.get(a));
		list.set(a, value);
	}
}

package sort_algorithms;

import java.util.ArrayList;

public class MergeSort <T extends Comparable<T>> implements Sort<T>{

	@Override
	public void sortAscending(T[] array) {
		int i = 0;
		int j = array.length-1;
		
		mergeSort(array, i, j);
	}

	private void mergeSort(T[] array, int i, int j) {
		if(i<j) {
			int mid = (i+j)/2;
			mergeSort(array, i, mid);
			mergeSort(array, mid+1, j);
			mixAscending(array, i, mid, j);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void mixAscending(T[] array, int i, int mid, int j) {
		Object[] aux = new Object[(j-i)+1];
		int l = i;
		int r = mid+1;
		int index = 0;
		
		while(l<=mid && r<=j) {
			if(array[l].compareTo(array[r])<0) {
				aux[index] = array[l];
				index++;
				l++;
			}else {
				aux[index] = array[r];
				index++;
				r++;
			}
		}
		
		if(l<=mid) {
			for (int k = l; k < mid+1; k++) {
				aux[index] = array[k];
				index++;
			}
		}else if(r<=j) {
			for (int k = r; k < j+1; k++) {
				aux[index] = array[k];
				index++;
			}
		}
		
		for (int k = 0; k < aux.length; k++) {
			array[i] = (T)aux[k];
			i++;
		}
	}

	@Override
	public void sortDescending(T[] array) {
		int i = 0;
		int j = array.length-1;
		
		mergeSortD(array, i, j);
	}

	private void mergeSortD(T[] array, int i, int j) {
		if(i<j) {
			int mid = (i+j)/2;
			mergeSortD(array, i, mid);
			mergeSortD(array, mid+1, j);
			mixDescending(array, i, mid, j);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void mixDescending(T[] array, int i, int mid, int j) {
		Object[] aux = new Object[(j-i)+1];
		int l = i;
		int r = mid+1;
		int index = 0;
		
		while(l<=mid && r<=j) {
			if(array[l].compareTo(array[r])>0) {
				aux[index] = array[l];
				index++;
				l++;
			}else {
				aux[index] = array[r];
				index++;
				r++;
			}
		}
		
		if(l<=mid) {
			for (int k = l; k < mid+1; k++) {
				aux[index] = array[k];
				index++;
			}
		}else if(r<=j) {
			for (int k = r; k < j+1; k++) {
				aux[index] = array[k];
				index++;
			}
		}
		
		for (int k = 0; k < aux.length; k++) {
			array[i] = (T)aux[k];
			i++;
		}
	}
	
	@Override
	public void sortAscending(ArrayList<T> list) {
		int i = 0;
		int j = list.size()-1;
		
		mergeSort(list, i, j);
	}
	
	private void mergeSort(ArrayList<T> list, int i, int j) {
		if(i<j) {
			int mid = (i+j)/2;
			mergeSort(list, i, mid);
			mergeSort(list, mid+1, j);
			mixAscending(list, i, mid, j);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void mixAscending(ArrayList<T> list, int i, int mid, int j) {
		Object[] aux = new Object[(j-i)+1];
		int l = i;
		int r = mid+1;
		int index = 0;
		
		while(l<=mid && r<=j) {
			if(list.get(l).compareTo(list.get(r))<0) {
				aux[index] = list.get(l);
				index++;
				l++;
			}else {
				aux[index] = list.get(r);
				index++;
				r++;
			}
		}
		
		if(l<=mid) {
			for (int k = l; k < mid+1; k++) {
				aux[index] = list.get(k);
				index++;
			}
		}else if(r<=j) {
			for (int k = r; k < j+1; k++) {
				aux[index] = list.get(k);
				index++;
			}
		}
		
		for (int k = 0; k < aux.length; k++) {
			list.set(i, (T)aux[k]);
			i++;
		}
	}

	@Override
	public void sortDescending(ArrayList<T> list) {
		int i = 0;
		int j = list.size()-1;
		
		mergeSortD(list, i, j);
	}
	
	private void mergeSortD(ArrayList<T> list, int i, int j) {
		if(i<j) {
			int mid = (i+j)/2;
			mergeSortD(list, i, mid);
			mergeSortD(list, mid+1, j);
			mixDescending(list, i, mid, j);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void mixDescending(ArrayList<T> list, int i, int mid, int j) {
		Object[] aux = new Object[(j-i)+1];
		int l = i;
		int r = mid+1;
		int index = 0;
		
		while(l<=mid && r<=j) {
			if(list.get(l).compareTo(list.get(r))>0) {
				aux[index] = list.get(l);
				index++;
				l++;
			}else {
				aux[index] = list.get(r);
				index++;
				r++;
			}
		}
		
		if(l<=mid) {
			for (int k = l; k < mid+1; k++) {
				aux[index] = list.get(k);
				index++;
			}
		}else if(r<=j) {
			for (int k = r; k < j+1; k++) {
				aux[index] = list.get(k);
				index++;
			}
		}
		
		for (int k = 0; k < aux.length; k++) {
			list.set(i, (T)aux[k]);
			i++;
		}
	}

}

package sort_algorithms;

import java.util.ArrayList;

import model.User;

public interface Sort <T extends Comparable<T>>{

	void sortAscending(ArrayList<T> list);
	void sortDescending(T[] array);
	void sortDescending(ArrayList<T> list);
}

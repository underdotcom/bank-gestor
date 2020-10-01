package sort_algorithms;

import java.util.ArrayList;

public interface Sort <T extends Comparable<T>>{

	void sortAscending(T[] array);
	void sortDescending(T[] array);
	void sortAscending(ArrayList<T> list);
	void sortDescending(ArrayList<T> list);
}

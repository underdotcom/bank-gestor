package sort_algorithms;

import java.util.ArrayList;

public interface Sort <T extends Comparable<T>>{

	void sortAscending(T[] array);
	void sortAscending(ArrayList<T> list);
	void sortDescending(T[] array);
	void sortDescending(ArrayList<T> list);
}

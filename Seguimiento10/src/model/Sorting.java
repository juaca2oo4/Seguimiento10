package model;

import java.util.ArrayList;

public class Sorting<T extends Comparable<T>> {

    public Sorting() {
    }

    public ArrayList<T> insertSort(ArrayList<T> listToSort) {
        for (int i = 1; i < listToSort.size(); i++) {
            T current = listToSort.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(listToSort.get(j)) < 0) {
                listToSort.set(j + 1, listToSort.get(j));
                --j;
            }
            listToSort.set(j + 1, current);
        }
        return listToSort;
    }
}

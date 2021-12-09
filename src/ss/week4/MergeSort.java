package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>>
    void mergesort(List<E> list) {
        int size = list.size();
        if (size > 1) {
            int half = size / 2;
            List<E> fst = copyPartialArray(list, 0, half);
            List<E> snd = copyPartialArray(list, half, size);
            mergesort(fst);
            mergesort(snd);
            merge(fst, snd, list);
        }
    }

    //merge two arrays together
    public static <E extends Comparable<E>> void merge(List<E> fst, List<E> snd, List<E> list) {
        int fs = fst.size();
        int s2 = snd.size();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < fs && j < s2) {
            if (fst.get(i).compareTo(snd.get(j)) < 0) {
                list.set(k, fst.get(i));
                i++;
            } else {
                list.set(k, snd.get(j));
                j++;
            }
            k++;
        }
        if (i == fs)
            for (int p = j; p < s2; p++) {
                list.set(k, snd.get(p)); k++;
            } else if (j == s2)
            for (int p = i; p < fs; p++) {
                list.set(k, fst.get(p)); k++;
            }
    }

    private static <E extends Comparable<E>> List<E> copyPartialArray(List<E> A, int first, int last) {
        int n = last - first;
        List<E> copy = new ArrayList<E>(n);
        for (int i = 0; i < n; i++){
            copy.add(i, A.get(first + i));
        }
        return copy;
    }

}
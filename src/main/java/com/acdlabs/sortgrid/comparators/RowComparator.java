package com.acdlabs.sortgrid.comparators;

import java.util.Comparator;

/**
 * RowComparator compares rows on the grid. To compare the rows it compares cells from the first column of the rows.
 * If the cells in the columns are equal then it compares next ones. With the same prefixes shorter row is considered as less;
 * @implNote This class is null-safe: any null value will be treated as the least value and null equals to null.
 */
public class RowComparator implements Comparator<String[]> {

    private final Comparator<String> cellComparator;

    public RowComparator(Comparator<String> cellComparator) {
        this.cellComparator = cellComparator;
    }

    @Override
    public int compare(String[] o1, String[] o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }

        if (o1 == null) {
            return -1;
        }

        if (o2 == null) {
            return 1;
        }

        int min = Math.min(o1.length, o2.length);
        for (int i = 0; i < min; i++) {
            int compareResult = cellComparator.compare(o1[i], o2[i]);
            if (compareResult != 0) {
                return compareResult;
            }
        }

        return Integer.compare(o1.length, o2.length);
    }
}

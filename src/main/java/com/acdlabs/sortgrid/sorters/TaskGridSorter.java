package com.acdlabs.sortgrid.sorters;

import com.acdlabs.sortgrid.comparators.CellComparator;
import com.acdlabs.sortgrid.comparators.RowComparator;

import java.util.Arrays;
import java.util.Comparator;

public class TaskGridSorter implements GridSorter {

    private final Comparator<String[]> rowComparator;

    public TaskGridSorter() {
        Comparator<String> cellComparator = new CellComparator();
        rowComparator = new RowComparator(cellComparator);
    }

    @Override
    public void sort(String[][] grid) {
        Arrays.sort(grid, rowComparator);
    }
}

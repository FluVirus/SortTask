package com.acdlabs.sortgrid;

import com.acdlabs.sortgrid.externalizers.TSVFileGridExternalizer;
import com.acdlabs.sortgrid.externalizers.GridExternalizer;
import com.acdlabs.sortgrid.providers.TSVFileGridProvider;
import com.acdlabs.sortgrid.providers.GridProvider;
import com.acdlabs.sortgrid.sorters.GridSorter;
import com.acdlabs.sortgrid.sorters.TaskGridSorter;

public class App {
    private static final String FILE_IN = "in.txt";
    private static final String FILE_OUT = "out.txt";

    private final String[] args;

    public App(String[] args) {
        this.args = args;
    }

    public void launch() throws Exception {
        String[][] grid;

        try (GridProvider gridProvider = new TSVFileGridProvider(FILE_IN)) {
            grid = gridProvider.provide();
        }

        GridSorter sorter = new TaskGridSorter();
        sorter.sort(grid);

        try (GridExternalizer gridExternalizer = new TSVFileGridExternalizer(FILE_OUT)) {
            gridExternalizer.externalize(grid);
        }
    }
}

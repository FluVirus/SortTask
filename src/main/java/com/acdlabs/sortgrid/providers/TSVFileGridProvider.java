package com.acdlabs.sortgrid.providers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TSVFileGridProvider implements GridProvider {

    private static final String COLUMN_SEPARATOR = "\t";

    private final BufferedReader reader;

    public TSVFileGridProvider(String filename) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filename));
    }

    @Override
    public String[][] provide() throws IOException {
        final List<String[]> rows = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] row = line.split(COLUMN_SEPARATOR, -1);
            rows.add(row);
        }

        return rows.toArray(new String[0][]);
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}

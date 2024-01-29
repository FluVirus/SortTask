package com.acdlabs.sortgrid.externalizers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSVFileGridExternalizer implements GridExternalizer {

    private static final String COLUMN_SEPARATOR = "\t";
    private final BufferedWriter writer;

    public TSVFileGridExternalizer(String filename) throws IOException {
        writer = new BufferedWriter(new FileWriter(filename));
    }

    @Override
    public void externalize(String[][] grid) throws IOException {
        for (String[] row : grid) {
            writer.append(String.join(COLUMN_SEPARATOR, row));
            writer.append(System.lineSeparator());
        }
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}

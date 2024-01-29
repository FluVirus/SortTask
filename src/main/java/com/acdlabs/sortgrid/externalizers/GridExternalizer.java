package com.acdlabs.sortgrid.externalizers;

import java.io.IOException;

public interface GridExternalizer extends AutoCloseable {
    void externalize(String[][] grid) throws IOException;
}

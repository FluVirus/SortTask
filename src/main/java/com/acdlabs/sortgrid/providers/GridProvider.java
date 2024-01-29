package com.acdlabs.sortgrid.providers;

import java.io.IOException;

public interface GridProvider extends AutoCloseable {
    String[][] provide() throws IOException;
}

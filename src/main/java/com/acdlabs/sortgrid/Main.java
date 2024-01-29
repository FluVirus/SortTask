package com.acdlabs.sortgrid;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    private static void printExceptionInfo(Exception e) {
        if (e == null) {
            System.out.println("null exception");
            return;
        }

        System.out.println("Exception: " + e.getClass().getName());
        System.out.println("Message: " + e.getMessage());
        e.printStackTrace();
    }

    public static void main(String[] args) {
        try {
            App app = new App(args);
            app.launch();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File cannot be found. See stack trace for details.");
            printExceptionInfo(fnfe);
        } catch (IOException ioe) {
            System.out.println("Something strange with IO operation. See stack trace for details.");
            printExceptionInfo(ioe);
        } catch (Exception e) {
            System.out.println("Unknown exception occurred. See stack trace for details.");
            printExceptionInfo(e);
        }
    }
}

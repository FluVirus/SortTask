package com.acdlabs.sortgrid.comparators;

import java.util.Comparator;

/**
 * CellComparator compares atoms of data in the grid.
 * It satisfies several task requirements:
 *  <ol>
 *     <li>Any numeric string less than any other one</li>
 *     <li>Numeric strings are compared as number they represent</li>
 *     <li>Other strings are compared in the lexicographical order</li>
 *  </ol>
 * Due to ... this comparator assumes:
 * <ol>
 *     <li>Number is any string that can be converted to finite double with {@link Double#parseDouble} method.</li>
 *     <li>If cells as numbers are equal but their string representations differ then cells will be compared as strings.</li>
 * </ol>
 * @implNote This class is null-safe: any null value will be treated as the least value and null equals to null.
 */
public class CellComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        double d1 = 0, d2 = 0;
        boolean isO1Double, isO2Double;

        //nulls less than anything but this comparator is not dedicated for compute nullables
        if (o1 == null && o2 == null) {
            return 0;
        }

        if (o1 == null) {
            return -1;
        }

        if (o2 == null) {
            return 1;
        }

        //parse strings as doubles
        try {
            d1 = Double.parseDouble(o1);
            isO1Double = Double.isFinite(d1);
        } catch (NumberFormatException nfe) {
            isO1Double = false;
        }

        try {
            d2 = Double.parseDouble(o2);
            isO2Double = Double.isFinite(d2);
        } catch (NumberFormatException nfe) {
            isO2Double = false;
        }

        //if the first string contains a number and the second does not
        if (isO1Double && !isO2Double) {
            return -1;
        }

        //if the first string does not contain a number but the second does
        if (!isO1Double && isO2Double) {
            return 1;
        }

        //if both strings contain number
        if (isO1Double) {
            int compareResult = Double.compare(d1, d2);
            if (compareResult == 0) {
                return o1.compareTo(o2);
            }

            return compareResult;
        }

        //if both strings do not contain number
        return o1.compareTo(o2);
    }
}

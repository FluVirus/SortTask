package com.acdlabs.sortgrid;

import com.acdlabs.sortgrid.sorters.GridSorter;
import com.acdlabs.sortgrid.sorters.TaskGridSorter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TaskGridSorterTests {

    @Test
    public void testSorter() {
        //Arrange
        String[][] sourceGrid = new String[][]{
                {"-2.2", "2", "3", "4"},
                {"2.2", "12345q", "69", "-afg"},
                {"2.2", "12345q", "69", "-asdf"},
                {"-22", "1234234", "asdfasf", "asdgas"},
                {"-22", "11", "abc", ""},
                {"-22", "-3", "4", ""},
                {"", "", "", ""},
                {"-1.1", "", "", ""},
                {"", "", "", ""},
                {"qqqq", "q1.1"},
                {"qqqq", "0.1"},
                {"qqqq", "-1.1"},
        };

        String[][] expectedGrid = new String[][]{
                {"-22", "-3", "4", ""},
                {"-22", "11", "abc", ""},
                {"-22", "1234234", "asdfasf", "asdgas"},
                {"-2.2", "2", "3", "4"},
                {"-1.1", "", "", ""},
                {"2.2", "12345q", "69", "-afg"},
                {"2.2", "12345q", "69", "-asdf"},
                {"", "", "", ""},
                {"", "", "", ""},
                {"qqqq", "-1.1"},
                {"qqqq", "0.1"},
                {"qqqq", "q1.1"},
        };

        GridSorter sorter = new TaskGridSorter();

        //Act
        sorter.sort(sourceGrid);

        //Assert
        assertArrayEquals(sourceGrid, expectedGrid);
    }
}

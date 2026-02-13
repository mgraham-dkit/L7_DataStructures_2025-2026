package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void getSize_EmptyList() {
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Set up test case information

        // Set expected result
        int expectedSize = 0;

        // Run method
        int actualResult = testList.getSize();

        // Compare/assert expected with reality
        assertEquals(expectedSize, actualResult, "Size of empty list is incorrect");
    }

    @Test
    void getSize_PopulatedList() {
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Set up test case information
        testList.add("Hello");

        // Set expected result
        int expectedSize = 1;

        // Run method
        int actualResult = testList.getSize();

        // Compare/assert expected with reality
        assertEquals(expectedSize, actualResult, "Size of populated list is incorrect");
    }
}
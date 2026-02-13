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

    @Test
    void contains_NullElement(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // No other prep required as the code will trigger an exception

        // Assert that the appropriate exception was thrown
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testList.contains(null);
                }, "Incorrect (or no) exception thrown"
        );
    }
}
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
    void contains_notPresent_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Set up test case information
        testList.add("Hello");
        testList.add("Goodbye");

        // Set expected result
        boolean expected = false;

        // Run method
        String target = "Oh no";
        boolean actualResult = testList.contains(target);

        // Compare/assert expected with reality
        assertEquals(expected, actualResult, "Element was found but is not present in list");
    }


    @Test
    void contains_notPresent_EmptyList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Set up test case information
        // No information added in empty list text

        // Set expected result
        boolean expected = false;

        // Run method
        String target = "Oh no";
        boolean actualResult = testList.contains(target);

        // Compare/assert expected with reality
        assertEquals(expected, actualResult, "Element was found but is not present in list");
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

    @Test
    void add_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list
        String [] elements = {"First element", "Second element", "Third element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        int expectedSize = elements.length + 1;
        String toBeAdded = "New element";

        // Add new element
        testList.add(toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualLastElement = testList.get(testList.getSize()-1);
        assertEquals(toBeAdded, actualLastElement, "Last element in list does not match what was added");

        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }
    }
}
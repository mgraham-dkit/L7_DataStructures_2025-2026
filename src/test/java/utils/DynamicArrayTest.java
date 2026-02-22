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
    void add_InvalidElement_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list
        String [] elements = {"First element", "Second element", "Third element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        int expectedSize = elements.length;
        String invalidElement = null;

        // Assert that the appropriate exception was thrown when adding null element
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testList.add(invalidElement);
                }, "Incorrect (or no) exception thrown when attempting to add an invalid element (null)"
        );

        // Check values
        // Assert that size has not been updated
        assertEquals(expectedSize, testList.getSize(), "Size changed when adding invalid element");

        // Assert that element was not added
        String actualLastElement = testList.get(testList.getSize()-1);
        assertEquals(elements[elements.length-1], actualLastElement, "Last element in list does not match original " +
                "last element");

        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }
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

    @Test
    void add_PopulatedList_OneElementPresent(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list
        String element = "First element";
        testList.add(element);

        // Define expectations:
        int expectedSize = 2;
        String toBeAdded = "New element";

        // Add new element
        testList.add(toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualLastElement = testList.get(testList.getSize()-1);
        assertEquals(toBeAdded, actualLastElement, "Last element in list does not match what was added");

        assertEquals(element, testList.get(0), "Element at position " + 0 + " does not match original data");

    }

    @Test
    void add_EmptyList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Define expectations:
        int expectedSize = 1;
        String toBeAdded = "New element";

        // Add new element
        testList.add(toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualLastElement = testList.get(0);
        assertEquals(toBeAdded, actualLastElement, "Last element in list does not match what was added");
    }

    /*
    Tests for add at position:
        - add to before the list starts (-1) - confirm method can catch positions less than 0
        - add to after the list ends (5) - confirm method can catch positions past the end of the list
        - add to 0 position of empty list - confirm method can add at the start of an empty list [no shift
        needed]
        - add to 0 position of populated list - confirm method can add to the start to a populated list
        [confirms shift action is done correctly]
        - add to middle of populated list - confirm method can add to the middle of a populated list
        [confirms that shift action does not change values before the position to be inserted at, but DOES shift all
        values after that]
        - add to after end of populated list - confirm method can add after the list ends [confirms shift
        will not be enacted for data before the position specified]
        - add invalid element (null) to list - confirm method will not allow null elements to be added
     */

    @Test
    void add_IllegalPosition_BeforeList_EmptyList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Define expectations:
        int expectedSize = 0;
        String toBeAdded = "New element";
        int illegalPosition = -1;

        // Assert that the appropriate exception was thrown when adding element to an illegal position (after end of
        // list)
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testList.add(illegalPosition, toBeAdded);
                }, "Incorrect (or no) exception thrown when adding to illegal position (before list begins) in empty " +
                        "list"
        );

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not stay the same when attempting to add to " +
                "an illegal position (before list begins) in an empty list");
    }

    @Test
    void add_IllegalPosition_EmptyList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Define expectations:
        int expectedSize = 0;
        String toBeAdded = "New element";
        int illegalPosition = 5;

        // Assert that the appropriate exception was thrown when adding element to an illegal position (after end of
        // list)
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testList.add(illegalPosition, toBeAdded);
                }, "Incorrect (or no) exception thrown when adding to illegal position in empty list"
        );

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not stay the same when attempting to add to " +
                "an illegal position in an empty list");
    }

    @Test
    void add_ZeroPosition_EmptyList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Define expectations:
        int expectedSize = 1;
        String toBeAdded = "New element";
        int expectedPosition = 0;

        // Add new element
        testList.add(expectedPosition, toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualLastElement = testList.get(expectedPosition);
        assertEquals(toBeAdded, actualLastElement, "Last element in list does not match what was added");
    }

    @Test
    void add_AddToStart_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list with known values
        String [] elements = {"First element", "Second element", "Third element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        // Size should go up
        int expectedSize = elements.length + 1;
        // Element inserted should match this
        String toBeAdded = "New element";
        // Element should be added at this position
        int expectedPosition = 0;

        // Add new element
        testList.add(expectedPosition, toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualInsertedElement = testList.get(expectedPosition);
        assertEquals(toBeAdded, actualInsertedElement, "Element at specified position in list does not match what was " +
                "added");

        // Assert that all original elements in list are in original order, just shifted to the right by 1
        for (int i = 0; i < expectedPosition; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }

        for (int i = expectedPosition; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i+1), "Element at position " + i+1 + " does not match source data " +
                    "array");
        }
    }

    @Test
    void add_AddToMiddle_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list with known values
        String [] elements = {"First element", "Second element", "Third element", "Fourth element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        // Size should go up
        int expectedSize = elements.length + 1;
        // Element inserted should match this
        String toBeAdded = "New element";
        // Element should be added at this position (middle of list)
        int expectedPosition = 2;

        // Add new element
        testList.add(expectedPosition, toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualInsertedElement = testList.get(expectedPosition);
        assertEquals(toBeAdded, actualInsertedElement, "Element at specified position in list does not match what was " +
                "added");

        // Assert that all original elements in list are in original order, just shifted to the right by 1
        for (int i = 0; i < expectedPosition; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }

        for (int i = expectedPosition; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i+1), "Element at position " + i+1 + " does not match source data " +
                    "array");
        }
    }

    @Test
    void add_AddToAfterEnd_PopulatedList(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list with known values
        String [] elements = {"First element", "Second element", "Third element", "Fourth element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        // Size should go up
        int expectedSize = elements.length + 1;
        // Element inserted should match this
        String toBeAdded = "New element";
        // Element should be added at this position (after end of list)
        int expectedPosition = 4;

        // Add new element
        testList.add(expectedPosition, toBeAdded);

        // Check values
        // Assert that size has been updated correctly
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that element was added in correct location
        String actualInsertedElement = testList.get(expectedPosition);
        assertEquals(toBeAdded, actualInsertedElement, "Element at specified position in list does not match what was " +
                "added");

        // Assert that all original elements in list are in original order, just shifted to the right by 1
        for (int i = 0; i < expectedPosition; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }

        for (int i = expectedPosition; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i+1), "Element at position " + i+1 + " does not match source data " +
                    "array");
        }
    }

    @Test
    void add_AddAfterEnd_PopulatedList_InvalidElement(){
        // Create instance of class under test
        DynamicArray testList = new DynamicArray();

        // Populate list with known values
        String [] elements = {"First element", "Second element", "Third element", "Fourth element"};
        for (int i = 0; i < elements.length; i++) {
            testList.add(elements[i]);
        }

        // Define expectations:
        // Size should not go up
        int expectedSize = elements.length;
        // Element inserted should match this
        String toBeAdded = null;
        // Attempt to add at this position
        int attemptedPosition = 2;

        // Assert that the appropriate exception was thrown when attempting to add invalid element to list
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testList.add(attemptedPosition, toBeAdded);
                }, "Incorrect (or no) exception thrown when attempting to add invalid element to the list"
        );


        // Check values
        // Assert that size was NOT updated
        assertEquals(expectedSize, testList.getSize(), "Size did not increase by 1 when adding single element");

        // Assert that all original elements in list are in original order and have not been moved
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], testList.get(i), "Element at position " + i + " does not match source data " +
                    "array");
        }
    }
}
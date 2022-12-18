package com.technicaltest;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilesFunctionalitiesTest {


    @Test
    public void testGetElementsOfFolders() {
        String[] expectedResult = new String[3];
        expectedResult[0] ="bonjour";
        expectedResult[1] ="bonjour\\bonjour.rtf";
        expectedResult[2] ="hey.rtf";
        assertEquals( "Showing folder structure should work: ", FilesFunctionalities.getElementsOfFolders("C:\\Users\\houss\\Desktop\\hello",28), expectedResult);
    }

}
package com.technicaltest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

public class ListsImplementedUtilsTest {

    @Test
    public void sortListTest() {
        String[] inputList = new String[5];
        inputList[0] = "t";
        inputList[1] = "m";
        inputList[2] = "i";
        inputList[3] = "t";
        inputList[4] = "u";

        //alphabetically ordered list : i m t t u
        String[] expectedResult = {"i","m","t","t","u"};
        assertEquals( "sorting list should work: ", ListsImplementedUtils.sortList(inputList,5), expectedResult);
    }

    @Test
    public void findCommonElementSortedListsTest() {
        String[] sortedListOne = {"a","b","c","d"};
        String[] sortedListTwo = {"c","d","e","f"};
        String[] expectedCommonList = {"c","d"};
        Set<String> res = ListsImplementedUtils.FindCommonElementSortedLists(sortedListOne,sortedListTwo);
        String[] arr = new String[2];
        Iterator<String> itr = res.iterator();
            arr[0] = itr.next();
            arr[1] = itr.next();
        assertEquals( "finding common list should work: ", arr, expectedCommonList);




    }

    @Test
    public void fileExistsTest() {
        String fileName = "file.txt";
        Set<String> set = new HashSet<>();
        set.add("filo.rtf");
        set.add("mittu");
        set.add("helloWorld.java");
        boolean expectedResponse = false;
        assertEquals( "finding common list should work: ", ListsImplementedUtils.fileExists(fileName,set), expectedResponse);
    }
}
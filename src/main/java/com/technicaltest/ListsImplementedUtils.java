package com.technicaltest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListsImplementedUtils {


   public static String[] sortList(String[] inputList, int n) {
       String temp;
       for (int i = 0; i < n; i++) {
           for (int j = i + 1; j < n; j++) {

               // to compare one string with other strings
               if (inputList[i].compareTo(inputList[j]) > 0) {
                   // swapping
                   temp = inputList[i];
                   inputList[i] = inputList[j];
                   inputList[j] = temp;
               }
           }
       }
       return inputList;
   }


    public static Set<String> FindCommonElementSortedLists(String[] arr1,
                                         String[] arr2)
    {
        //arr1 : source
        //arr2 destination
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    // add common elements
                    set.add(arr1[i]);
                    break;
                }
            }
        }
        return set;
    }


    public static boolean fileExists(String file,Set<String> set){
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            if(itr.next().equals(file))
                return true;
        }
        return false;
    }

}

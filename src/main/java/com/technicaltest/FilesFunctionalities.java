package com.technicaltest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;



public class FilesFunctionalities {

    //static field to store resulting arraylist.
    public static List<String> arrayList;


    //recursive function : STRATEGY : if folder delete it recursively : if file delete it right away
    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    //recursive function : STRATEGY : if folder the return its elements then return it if file return it right away.
    public static String[] getElementsOfFolders(String filePath,int offset){
        File destinationFol = new File(filePath);
        String[] entries = destinationFol.list();
        List<String> arrList
                = new ArrayList<>(
                Arrays.asList(entries));

        if(offset == filePath.length())
            if(entries.length!=0) {
                arrayList = new ArrayList<>(Arrays.asList(entries[0]));
            }
        //empty source folder.
        else{
            return new String[0];
            }

        for(String s: entries){
            File currentFile = new File(destinationFol.getPath(),s);
            if(currentFile.isDirectory()){
                getElementsOfFolders(destinationFol.getPath()+"\\"+s,offset);
                String path = destinationFol.getPath()+"\\"+s;
                arrList.add(path.substring(offset));
            }
            else{
                String h = destinationFol.getPath()+"\\"+s;
                String path = h.substring(offset+1);
                arrList.add(path);
                arrayList.add(path);
            }
            }
        return arrayList.toArray(new String[arrayList.size()-1]);
    }


    public static void addFilesFromSource(String sourceDirectoryLocation, String destinationDirectoryLocation, Set<String> commonFiles){
        try {
            Files.walk(Paths.get(sourceDirectoryLocation))
                    .forEach(source -> {
                        String shortPath = source.toString().substring(sourceDirectoryLocation.length());
                        File currentFileOrFolder = new File(source.toString());
                        if (shortPath.equals(sourceDirectoryLocation.toString().substring(sourceDirectoryLocation.length()))) {
                            //skip because pointing to the same actual directory.
                        } else if (!ListsImplementedUtils.fileExists(source.toString().substring(sourceDirectoryLocation.length() + 1), commonFiles)) {
                            Path destination = Paths.get(destinationDirectoryLocation, shortPath);
                            //if the current element is a file then copy to destination directly
                            //else if it's a folder then check if it's empty => do not copy! or if it has files => copy.
                            if (currentFileOrFolder.isFile()) {
                                try {
                                    Files.copy(source, destination);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                //folder is not empty => do copy
                                if (currentFileOrFolder.listFiles().length != 0) {
                                    try {
                                        Files.copy(source, destination);
                                    }
                                    catch (IOException e) {
                                    }
                                }
                                //folder is empty => do nothing
                                else {
                                    //do nothing.
                                }
                            }
                        }
                    });
        }
        catch (Exception e){
            System.out.println("Application exited due to an ERROR!");
            System.out.println("Error Message : ");
            e.printStackTrace();
        }
    }
}
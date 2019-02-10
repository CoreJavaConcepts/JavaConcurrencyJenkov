package com.java.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {
    private final String path;
    private final String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> fileNamesList = new ArrayList<>();

        List<FolderProcessor> tasks = new ArrayList<>();
        File allfiles = new File(path);
        File[] content = allfiles.listFiles();

        if(content != null){
            for(File file : content){
                if(file.isDirectory()){
                    FolderProcessor task = new FolderProcessor(file.getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else{
                    if (checkFile(file.getName())) {
                        fileNamesList.add(file.getAbsolutePath());
                    }
                }
            }
        }

        if(tasks.size() > 50){
            System.out.printf("%s: %d tasks ran.\n", allfiles.getAbsolutePath(), tasks.size());
        }
        //add to the list of files the results returned by the subtasks launched by this task.
        addResultsFromTasks(fileNamesList, tasks);
        //Return the list of strings
        return fileNamesList;
    }

    private boolean checkFile(String name)
    {
        return name.endsWith(extension);
    }

    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks)
    {
        for (FolderProcessor item : tasks)
        {
            list.addAll(item.join());
        }
    }
}

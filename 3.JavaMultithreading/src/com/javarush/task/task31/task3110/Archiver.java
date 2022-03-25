package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));

        Path targetToArchivision = Paths.get(reader.readLine());
        zipFileManager.createZip(targetToArchivision);

        new ExitCommand().execute();
    }
}

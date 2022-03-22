package com.javarush.task.task31.task3110;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Path pathOfArchive = Paths.get(scanner.next());
        ZipFileManager zipFileManager = new ZipFileManager(pathOfArchive);

        Path targetToArchivision = Paths.get(scanner.next());
        zipFileManager.createZip(targetToArchivision);
    }
}

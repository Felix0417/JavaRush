package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("из какого архива будем удалять файл:");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("какой файл будем удалять:");
        Path destinationPath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(destinationPath);
        ConsoleHelper.writeMessage("файл удален, наслаждайтесь новым архивом");
    }
}

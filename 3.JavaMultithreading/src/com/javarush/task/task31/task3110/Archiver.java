package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Archiver {

    public static Operation askOperation() throws Exception {
        int numOfOperation;
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                Operation.CREATE.ordinal() + " - упаковать файлы в архив\n" +
                Operation.ADD.ordinal() + " - добавить файл в архив\n" +
                Operation.REMOVE.ordinal() + " - удалить файл из архива\n" +
                Operation.EXTRACT.ordinal() + " - распаковать архив\n" +
                Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\n" +
                Operation.EXIT.ordinal() + " - выход");
        while (true){
            numOfOperation = ConsoleHelper.readInt();
            for (Operation o : Operation.values()){
                if (numOfOperation == o.ordinal()){
                    return o;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Operation operation = null;
        while (!Operation.EXIT.equals(operation)) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e){
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception en){
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
    }
}

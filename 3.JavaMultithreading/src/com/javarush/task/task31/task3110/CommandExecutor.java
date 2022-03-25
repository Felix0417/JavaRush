package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor{
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_KNOWN_COMMANDS_MAP.put(Operation.ADD, new ZipAddCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CONTENT, new ZipContentCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CREATE, new ZipCreateCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXTRACT, new ZipExtractCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.REMOVE, new ZipRemoveCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor(){}

    public static void execute(Operation operation) throws Exception {
        switch (operation){
            case ADD:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.ADD).execute();
                break;
            case CONTENT:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.CONTENT).execute();
                break;
            case CREATE:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.CREATE).execute();
                break;
            case EXTRACT:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.EXTRACT).execute();
                break;
            case REMOVE:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.REMOVE).execute();
                break;
            case EXIT:
                ALL_KNOWN_COMMANDS_MAP.get(Operation.EXIT).execute();
                break;
        }

    }
}

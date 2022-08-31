package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String name = f.getName().toLowerCase();
        return f.isDirectory() || name.matches("\\.html?$");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}

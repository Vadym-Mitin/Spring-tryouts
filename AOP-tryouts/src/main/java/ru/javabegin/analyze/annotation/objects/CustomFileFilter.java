package ru.javabegin.analyze.annotation.objects;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Vadym Mitin
 */
public class CustomFileFilter implements FilenameFilter {

    private String extension;

    public CustomFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }
}

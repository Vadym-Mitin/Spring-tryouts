package ru.javabegin.analyze.xml.objects;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Vadym Mitin
 */
@Component
public class FileXMLAnalyzer {
    public Set<String> getExtensionList(String folder) {
        Set<String> extensions = new TreeSet<>();

        File directory = new File(folder);
        File[] files = directory.listFiles();

        for (File file : files) {
            String fileName = file.getName();
            int i = fileName.lastIndexOf('.');
            if (file.isFile() && i != -1) {
                String extension = fileName.substring(i + 1).toLowerCase();
                extensions.add(extension);
            }
        }

        return extensions;
    }

    public Map<String, Integer> getExtensionCount(String folder) {
        File directory = new File(folder);

        Map<String, Integer> map = new HashMap<>();

        for (String ext : getExtensionList(folder)) {
            FilenameFilter filter = new CustomFileFilter(ext);
            map.put(ext, directory.listFiles(filter).length);
        }
        return map;
    }

}

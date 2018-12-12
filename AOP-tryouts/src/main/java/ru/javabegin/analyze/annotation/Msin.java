package ru.javabegin.analyze.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.analyze.annotation.objects.FileAnalyzer;

import java.util.Map;

/**
 * @author Vadym Mitin
 */
class Msin {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("ru/javabegin/analyze/analyze-context-annotation.xml");

        FileAnalyzer analyzer = ctx.getBean("fileAnalyzer", FileAnalyzer.class);
        String folder = "c:\\windows\\system32";
        Map<String, Integer> extensionCount = analyzer.getExtensionCount(folder);

//        analyzer.getExtensionCount(folder);
        for (String s : extensionCount.keySet()) {
            Integer value = extensionCount.get(s);
            System.out.println(s + ": " + value);
        }
    }

}

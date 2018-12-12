package ru.javabegin.analyze.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.analyze.xml.objects.FileXMLAnalyzer;

import java.util.Map;

/**
 * @author Vadym Mitin
 */
class Msin {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("ru/javabegin/analyze/analyze-context-xml.xml");

        FileXMLAnalyzer analyzer = ctx.getBean("fileAnalyzer", FileXMLAnalyzer.class);
        String folder = "c:\\windows\\system32";
        Map<String, Integer> extensionCount = analyzer.getExtensionCount(folder);

//        analyzer.getExtensionCount(folder);
        for (String s : extensionCount.keySet()) {
            Integer value = extensionCount.get(s);
            System.out.println(s + ": " + value);
        }
    }

}

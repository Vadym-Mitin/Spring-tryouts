package ru.javabegin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.dao.MP3;
import ru.javabegin.dao.PostgresDao;

import java.util.Map;

/**
 * @author Vadym Mitin
 */
public class Main {
    public static void main(String[] args) {
//        MP3 mp3 = new MP3();
//        mp3.setName("Like a teen spirit");
//        mp3.setAuthor("Nirvana");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PostgresDao postgresDao = context.getBean("postgresDao", PostgresDao.class);


//        postgresDao.insert(mp3);
        MP3 mp3ById = postgresDao.getMP3(3);

//        Map<String, Integer> statistic = postgresDao.getStatistic();
//        for (String s : statistic.keySet()) {
//            System.out.println(s + "  ;  " + statistic.get(s));
//        }
//        postgresDao.delete(mp3ById);


    }
}

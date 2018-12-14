package ru.javabegin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.dao.MP3;
import ru.javabegin.dao.PostgresDao;

/**
 * @author Vadym Mitin
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PostgresDao postgresDao = context.getBean("postgresDao", PostgresDao.class);

        MP3 mp3ById = postgresDao.getMP3ByID(68);
        System.out.println(mp3ById.toString());

    }
}

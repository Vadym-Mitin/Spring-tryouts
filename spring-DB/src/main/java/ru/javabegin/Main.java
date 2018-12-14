package ru.javabegin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.dao.Author;
import ru.javabegin.dao.MP3;
import ru.javabegin.dao.PostgresDao;

import java.util.Arrays;

/**
 * @author Vadym Mitin
 */
public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setName("John Dou");
        author.setId(999);

        MP3 mp3 = new MP3();
        mp3.setAuthor(author);
        mp3.setName("something about Love");


        Author author_2 = new Author();
        author_2.setName("Nirvana");
        author_2.setId(998);
        MP3 mp3_2 = new MP3();
        mp3_2.setAuthor(author_2);
        mp3_2.setName("Floyd the Barber");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PostgresDao postgresDao = context.getBean("postgresDao", PostgresDao.class);

        postgresDao.insert(mp3);
        postgresDao.insert(mp3_2);
//        MP3 mp3ById = postgresDao.getMP3ByID(68);
//        System.out.println(mp3ById.toString());

    }
}

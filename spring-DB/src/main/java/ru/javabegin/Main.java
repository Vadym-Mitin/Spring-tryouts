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
        MP3 mp3 = new MP3();
        mp3.setName("Like a teen spirit");
        mp3.setAuthor("Nirvana");

        // new SQLiteDAO().insertWithJDBC(mp3);

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PostgresDao postgresDao = context.getBean("postgresDao", PostgresDao.class);

        postgresDao.insert(mp3);
//        MP3 mp3ById = postgresDao.getMP3ById(3);

//        postgresDao.delete(mp3ById);


    }
}

package ru.javabegin.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Vadym Mitin
 */
public interface MP3Dao {
    void insert(MP3 mp3);

    void delete(MP3 mp3);

    <T> List<T> getMP3(String parameterName, Object parameterValue, Class<T> requiredType);

    Map<String, Integer> getStatistic();

    MP3 getMP3(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMP3ListByAuthor(String author);

}

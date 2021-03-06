package ru.javabegin.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Vadym Mitin
 */
public interface MP3Dao {
    int insertMP3(MP3 mp3);

    int insertList(List<MP3> mp3List);

    void delete(MP3 mp3);

    void delete(int id);

    MP3 getMP3ByID(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMP3ListByAuthor(String author);

    int getMP3Count();

    Map<String, Integer> getStat();

    /**
     * add author to db and return that id who generated by primary key
     *
     * @param author
     * @return int id
     */
    int insertAuthor(Author author);
}

package ru.javabegin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * @author Vadym Mitin
 */
@Component
public class PostgresDao implements MP3Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(MP3 mp3) {

        String author = mp3.getAuthor();
        String name = mp3.getName();

        jdbcTemplate.update("insert into mp3 (name,author) values (?,?);", name, author);

    }

    @Override
    public void delete(MP3 mp3) {

        int id = mp3.getId();

        jdbcTemplate.update("delete FROM mp3 WHERE id = ?", id);
    }

    @Override
    public MP3 getMP3(int id) {

        List<MP3> query = getMP3("id", id, MP3.class);

        Optional<MP3> optionalMP3 = query.stream().findFirst();
        return optionalMP3.orElse(null);
    }

    @Override
    public List<MP3> getMP3ListByName(String name) {

        List<MP3> listOfMP3 = getMP3("name", name, MP3.class);

        return listOfMP3;
    }

    @Override
    public List<MP3> getMP3ListByAuthor(String author) {

        List<MP3> listOfMP3 = getMP3("author", author, MP3.class);

        return listOfMP3;
    }

    @Override
    public <T> List<T> getMP3(String parameterName, Object parameterValue, Class<T> requiredType) {
        String preparedQery = "select * from mp3 where " + parameterName + "= ?";
        List<T> list = jdbcTemplate.query(preparedQery
                , new Object[]{parameterValue}
                , new BeanPropertyRowMapper<>(requiredType));

        return list;
    }

    @Override
    public Map<String, Integer> getStatistic() {
        Map<String, Integer> query = jdbcTemplate.query("select author, count(*) as count from mp3 group by author"
                , (resultSet) -> {
                    Map<String, Integer> data = new TreeMap<>();
                    while (resultSet.next()) {
                        String author = resultSet.getString("author");
                        int count = resultSet.getInt("count");
                        data.put(author, count);
                    }
                    return data;
                });
        return query;
    }

}

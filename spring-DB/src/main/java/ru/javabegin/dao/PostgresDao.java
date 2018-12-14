package ru.javabegin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Vadym Mitin
 */
@Component
public class PostgresDao implements MP3Dao {

    private static final String mp3Table = "mp3";
    private static final String mp3View = "mp3_view";

//    private SimpleJdbcInsert insertMP3;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.insertMP3 = new SimpleJdbcInsert(dataSource).withTableName("mp3").usingColumns("name", "author");
    }

    @Override
    public int insert(MP3 mp3) {

        boolean isMP3Exist = getMP3ListByName(mp3.getName()).size() > 0;
        if (isMP3Exist) {
            System.out.println("song already exist");
            return 0;
        }
        String authorName = mp3.getAuthor().getName();
        Author author = getAuthor(authorName);
        boolean isAuthorNotPresent = author == null;
        if (isAuthorNotPresent) {
            System.out.println("author:" + authorName + " not exist");
            addAuthor(authorName);
        }
        int author_id = getAuthor(authorName).getId();
        return addMP3(mp3, author_id);
    }

    private int addMP3(MP3 mp3, int author_id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("mp3Name", mp3.getName());
        parameters.addValue("authorId", author_id);

        String sql = "insert into mp3 (author_id, name) VALUES (:authorId, :mp3Name)";
        return jdbcTemplate.update(sql, parameters);
    }

    private void addAuthor(String authorName) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("authorName", authorName);

        String sql = "insert into author ( name) VALUES (:authorName)";
        jdbcTemplate.update(sql, parameters);

    }

    @Override
    public int insertList(List<MP3> listMP3) {
        int insertCounter = 0;
        for (MP3 mp3 : listMP3) {
            insert(mp3);
            insertCounter++;
        }
        return insertCounter;
    }

    @Override
    public Author getAuthor(String authorName) {
        return getAuthors(authorName).stream().findFirst().orElse(null);
    }

    @Override
    public List<Author> getAuthors(String authorName) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("authorName", authorName);

        List<Author> query = jdbcTemplate.query("select * from author where name = :authorName "
                , parameterSource
                , (rs, rowNum) -> {
                    String author_name = rs.getString("name");
                    int author_id = rs.getInt("id");
                    Author resultAuthor = new Author();
                    resultAuthor.setId(author_id);
                    resultAuthor.setName(author_name);
                    return resultAuthor;
                }
        );
        return query;

    }

    @Override
    public Map<String, Integer> getStat() {
        String sql = "select author_name, count(*) as count from " + mp3View + " group by author_name";

        return jdbcTemplate.query(sql, rs -> {
            Map<String, Integer> map = new TreeMap<>();
            while (rs.next()) {
                String author = rs.getString("author_name");
                int count = rs.getInt("count");
                map.put(author, count);
            }
            return map;
        });

    }

    @Override
    public void delete(int id) {
        String sql = "delete from mp3 where id=:id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(MP3 mp3) {
        delete(mp3.getId());
    }

    @Override
    public MP3 getMP3ByID(int id) {
        String sql = "select * from " + mp3View + " where mp3_id=:mp3_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3_id", id);

        return jdbcTemplate.queryForObject(sql, params, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByName(String mp3Name) {
        String sql = "select * from " + mp3View + " where upper(mp3_name) like :mp3_name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3_name", "%" + mp3Name.toUpperCase() + "%");

        return jdbcTemplate.query(sql, params, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByAuthor(String author) {
        String sql = "select * from " + mp3View + " where upper(author_name) like :author_name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_name", "%" + author.toUpperCase() + "%");

        return jdbcTemplate.query(sql, params, new MP3RowMapper());
    }

    @Override
    public int getMP3Count() {
        String sql = "select count(*) from " + mp3Table;
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final class MP3RowMapper implements RowMapper<MP3> {

        @Override
        public MP3 mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName(rs.getString("author_name"));

            MP3 mp3 = new MP3();
            mp3.setId(rs.getInt("mp3_id"));
            mp3.setName(rs.getString("mp3_name"));
            mp3.setAuthor(author);
            return mp3;
        }

    }


}

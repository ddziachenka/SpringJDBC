package dao.jdbc;

import dao.DeveloperDao;
import model.Developer;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DeveloperMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Dzmitry Dziachenka on 10/26/2018
 */
public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void createDeveloper(String name, String specialty, Integer experience) {
        String SQL = "INSERT INTO DEVELOPERS (name, specialty, experience) VALUES (?,?,?)";

        jdbcTemplate.update(SQL, name, specialty, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpecilaty: " +
                specialty + ";\nExperience: " + experience + "\n");
    }


    public Developer getDeveloperById(Integer id) {
        String SQL = "SELECT * FROM DEVELOPERS WHERE id = ?";
        Developer developer = (Developer) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DeveloperMapper());
        return developer;
    }


    public List listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        List developers = jdbcTemplate.query(SQL, new DeveloperMapper());
        return developers;
    }


    public void removeDeveloper(Integer id) {
        String SQL = "DELETE FROM DEVELOPERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Developer with id: " + id + " successfully removed");
    }


    public void updateDeveloper(Integer id, String name, String specialty, Integer experience) {
        String SQL = "UPDATE DEVELOPERS SET name = ?, specialty = ?, experience = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, specialty, experience, id);
        System.out.println("Developer with id: " + id + " successfully updated.");
    }
}

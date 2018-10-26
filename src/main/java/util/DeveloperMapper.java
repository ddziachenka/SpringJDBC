package util;

import model.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dzmitry Dziachenka on 10/26/2018
 */
public class DeveloperMapper implements RowMapper{

    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setSpecialty(rs.getString("specialty"));
        developer.setExperience(rs.getInt("experience"));
        return developer;
    }
}


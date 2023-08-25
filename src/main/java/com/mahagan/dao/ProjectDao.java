package com.mahagan.dao;

import com.mahagan.domain.Project;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class ProjectDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DataSource dataSource;
    private ProjectSqlUpadate projectSqlUpadate;

    private final String Upadate_SQL="Update form set collage=? where ino=? ";



    public ProjectDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.dataSource = dataSource;
        projectSqlUpadate=new ProjectSqlUpadate(dataSource,Upadate_SQL);

    }
    public int UpdateProjects(int ino,String collage )
    {
        return projectSqlUpadate.update(new Object[]{collage,ino});
    }

    private final class ProjectSqlUpadate extends SqlUpdate
    {
        public ProjectSqlUpadate(DataSource dataSource,String sql_query)
        {
            super(dataSource,sql_query);
            declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
            declareParameter(new SqlParameter(java.sql.Types.INTEGER));
            compile();
        }
    }

    private final String ADD_IN_SQL = "INSERT INTO FORM VALUES(:ino,:name,:collage,:city,:state)";

    public int insertintoproject(Project project)
    {
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ino",project.getIno());
        mapSqlParameterSource.addValue("name",project.getName());
        mapSqlParameterSource.addValue("collage",project.getCollage());
        mapSqlParameterSource.addValue("city",project.getCity());
        mapSqlParameterSource.addValue("state",project.getState());

        int count= namedParameterJdbcTemplate.update(ADD_IN_SQL,mapSqlParameterSource);
        return count;
    }
}

package dev.mihail.DAO;

import dev.mihail.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProjectJdbcDAO implements DAO<Project>{

    private static final Logger log = LoggerFactory.getLogger(ProjectJdbcDAO.class);
    private final JdbcTemplate jdbcTemplate;

    RowMapper<Project> projectRowMapper = (rs, rowNum) -> {
        Project project = new Project();
        project.setProject_id(rs.getInt("p_id"));
        project.setP_title(rs.getString("p_title"));
        project.setP_description(rs.getString("p_description"));
        project.setP_link(rs.getString("p_link"));
        return project;
    };

    public ProjectJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> listAll() {
        String sql = "SELECT p_id, p_title, p_description, p_link from project";
        return jdbcTemplate.query(sql, projectRowMapper);
    }

    @Override
    public void create(Project project) {
        String sql = "INSERT into project(p_title, p_description, p_link) values (?, ?, ?)";
        int insert = jdbcTemplate.update(sql, project.getP_title(), project.getP_description(), project.getP_link());
        if (insert == 1) {
            log.info("new project created: " + project.getP_title());
        }
    }

    @Override
    public Optional<Project> get(int id) {
        String query = "SELECT p_id, p_title, p_description, p_link from project where p_id = ?";
        Project project = null;

        try {
            project = jdbcTemplate.queryForObject(query, projectRowMapper, new Project().getProject_id());
        } catch (DataAccessException ex){
            log.info("Course not found: " + id);
        }
        return Optional.ofNullable(project);
    }

    @Override
    public void update(Project project, int id) {
        String query = "UPDATE project set p_title = ?, p_description = ?, p_link = ? where p_id = ?";
        int update = jdbcTemplate.update(query, project.getP_title(), project.getP_description(), project.getP_link());
        if (update == 1){
            log.info("Project was updated: " + project.getP_title());
        }
    }

    @Override
    public void delete(Project project, int id) {
        String query = "DELETE from project where id = ?";
        int delete = jdbcTemplate.update(query);
        if (delete == 1){
            log.info("Project with id: " + project.getProject_id() + "was deleted");
        }

    }
}

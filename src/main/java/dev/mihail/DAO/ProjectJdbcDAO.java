package dev.mihail.DAO;

import dev.mihail.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class ProjectJdbcDAO implements DAO<Project>{

    private static final Logger log = LoggerFactory.getLogger(ProjectJdbcDAO.class);

    @Override
    public List<Project> listAll() {
        return null;
    }

    @Override
    public void create(Project project) {

    }

    @Override
    public Optional<Project> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Project project, int id) {

    }

    @Override
    public void delete(Project project, int id) {

    }


}

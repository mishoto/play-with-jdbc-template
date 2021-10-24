package dev.mihail;

import dev.mihail.DAO.DAO;
import dev.mihail.model.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PlayWithJdbcApplication {

	private static DAO<Project> daoProject;

	public PlayWithJdbcApplication(DAO<Project> daoProject){
		this.daoProject = daoProject;
	}



	public static void main(String[] args) {
		SpringApplication.run(PlayWithJdbcApplication.class, args);


		System.out.println("######  Create Project ########");
		Project project = new Project("javaFive", "demoJavaApp", "https://java5.spring.dev");
		daoProject.create(project);


		System.out.println("######  Print All Projects ########");
		List<Project> projects = daoProject.listAll();
		projects.forEach(System.out::println);


	}

}

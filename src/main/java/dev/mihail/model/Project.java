package dev.mihail.model;

public class Project {

    private int project_id;
    private String p_title;
    private String p_description;
    private String p_link;

    public Project() {}

    public Project(String p_title, String p_description, String p_link) {
        this.p_title = p_title;
        this.p_description = p_description;
        this.p_link = p_link;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public String getP_link() {
        return p_link;
    }

    public void setP_link(String p_link) {
        this.p_link = p_link;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", p_title='" + p_title + '\'' +
                ", p_description='" + p_description + '\'' +
                ", p_link='" + p_link + '\'' +
                '}';
    }
}


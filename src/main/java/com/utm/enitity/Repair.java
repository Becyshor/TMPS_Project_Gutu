package main.java.com.utm.enitity;

public class Repair extends CarServiceEntity {

    private Long id;
    private String issue;
    private String resolution = "";

    public Repair(Long id, String issue) {
        setId(id);
        setIssue(issue);
    }

    public Repair() { }

    public Long getId() {
        return id;
    }

    public Repair setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIssue() {
        return issue;
    }

    public Repair setIssue(String issue) {
        this.issue = issue;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public Repair setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }
}

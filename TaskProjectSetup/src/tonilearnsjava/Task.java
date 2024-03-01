package tonilearnsjava;

enum Priority {HIGH, MEDIUM, LOW}

enum Status {IN_QUEUE, ASSIGNED, IN_PROGRESS}
public class Task implements Comparable<Task>{
    private String projectName;
    private String description;

    private String assignee;

    private Priority priority;
    private Status status;

    public Task(String projectName, String description, String assignee, Priority priority,
                Status status) {
        this.projectName = projectName;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public Task(String projectName, String description, String assignee, Priority priority) {
        this(projectName,description,assignee, priority, assignee == null ? Status.IN_QUEUE: Status.ASSIGNED);
    }

    public Task(String projectName, String description, Priority priority) {
        this(projectName,description,null,priority);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "%20s %25s %-10s %-10s %s".formatted(projectName,  description, priority, assignee,status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!getProjectName().equals(task.getProjectName())) return false;
        return getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProjectName().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {
       int result  = this.projectName.compareTo(o.projectName);
       if( result == 0){
           result = this.description.compareTo(o.description);
       }
       return result;
    }
}

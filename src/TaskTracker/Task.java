package TaskTracker;

public class Task {
    private static int id = 0;
    private String taskName;
    private String description;
    private int taskId;
    private STATUS status;

    public void setId(int id){
        Task.id = id;
    }
    public static int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Task(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
        this.status = STATUS.NEW;
    }

    public Task(String taskName, String description, STATUS status) {
        this.taskName = taskName;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", taskId=" + taskId +
                ", status=" + status +
                '}';
    }
}

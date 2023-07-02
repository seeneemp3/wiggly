package TaskTracker;

public class SubTask extends Task {
    private Integer epicId;

    private final TaskType type = TaskType.SUBTASK;

    public TaskType getType() {
        return type;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    public SubTask(String taskName, String description, Integer epicId) {
        super(taskName, description);
        this.epicId = epicId;
    }
    public SubTask(Integer id, String taskName, String description, STATUS status, Integer epicId) {
        super(id, taskName, description, status);
        this.epicId = epicId;
    }

    public SubTask(String taskName, String description, Integer epicId, STATUS status) {
        super(taskName, description, status);
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicId=" + epicId +
                ", taskName='" + getTaskName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", taskId=" + getTaskId() +
                ", status=" + getStatus() +
                '}';
    }
}

package TaskTracker;

public class SubTask extends Task {
    private Epic parent;

    public Epic getParent() {
        return parent;
    }

    public void setParent(Epic parent) {
        this.parent = parent;
    }

    public SubTask(String taskName, String description, Epic epic) {
        super(taskName, description);
        this.parent = epic;
    }

    public SubTask(String taskName, String description, Epic epic, STATUS status) {
        super(taskName, description, status);
        this.parent = epic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "parent=" + parent.getTaskName() +
                ", taskName='" + getTaskName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", taskId=" + getTaskId() +
                ", status=" + getStatus() +
                '}';
    }
}

package TaskTracker;

import java.util.Objects;

public class Task {
    private static int globalId = 0;
    private String taskName;
    private String description;
    private int taskId;
    private STATUS status;
    private final TaskType type = TaskType.TASK;

    public TaskType getType() {
        return type;
    }

    public void setGlobalId(int id){
        Task.globalId = id;
    }
    public static int getGlobalId() {
        return globalId;
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
    public Task(Integer id, String taskName, String description, STATUS status) {
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        taskId = id;
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
    @Override
    public int hashCode() {
        return Objects.hash(taskName,description,taskId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) return false;
        if(obj == this) return true;
        Task task = (Task) obj;
        return Objects.equals(taskName,task.taskName) &&
                Objects.equals(description,task.description ) &&
                Objects.equals(taskId,task.taskId );
    }


}


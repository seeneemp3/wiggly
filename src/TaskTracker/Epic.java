package TaskTracker;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final TaskType type = TaskType.EPIC;

    private List<SubTask> subs;
    public Epic(String taskName, String description) {
        super(taskName, description);
        this.subs = new ArrayList<>();
    }
    public Epic(Integer id, String taskName, String description, STATUS status) {
        super(id, taskName, description,  status);
        this.subs = new ArrayList<>();
    }

    public List<SubTask> getSubs() {
        return subs;
    }


    public TaskType getType() {
        return type;
    }


    @Override
    public String toString() {
        ArrayList<String> subs = new ArrayList<>();
        for (SubTask s : this.subs) {
            subs.add(s.getTaskName());
        }
        return "Epic{" +
                "taskName='" + getTaskName() + '\'' +
                ", description='" + getTaskName() + '\'' +
                ", taskId=" + getTaskId() +
                ", status=" + getStatus() +
                ", " + subs +
                '}';
    }
}

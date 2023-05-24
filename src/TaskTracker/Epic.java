package TaskTracker;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
   private List<SubTask> subs;

    public List<SubTask> getSubs() {
        return subs;
    }

    public Epic(String taskName, String description) {
        super(taskName, description);
        this.subs = new ArrayList<>();
    }


    @Override
    public String toString() {
        ArrayList<String> names = new ArrayList<>();
        for (SubTask s : subs) {
            names.add(s.getTaskName());
        }
        return "Epic{" +
                "taskName='" + getTaskName() + '\'' +
                ", description='" + getTaskName() + '\'' +
                ", taskId=" + getTaskId() +
                ", status=" + getStatus() +
                ", " + names +
                '}';
    }
}

package TaskTracker;

import java.util.List;
import java.util.stream.Collectors;

public class CSVConverter {


    public static String toString(Task task){
        String taskToString = "";
        if (task.getType().equals(TaskType.SUBTASK)){
            SubTask subTask = (SubTask) task;
            taskToString = subTask.getTaskId() + ","  + subTask.getType()+ "," + subTask.getTaskName() + "," + subTask.getStatus() + "," + subTask.getDescription() + "," + subTask.getTaskId();
        } else if(task.getType().equals(TaskType.EPIC)){
            Epic epic = (Epic) task;
            taskToString = epic.getTaskId() + "," + epic.getType() + "," + epic.getTaskName() + "," + epic.getStatus() + "," + epic.getDescription() + "," ;
        } else{
            taskToString = task.getTaskId() + "," + task.getType() + "," + task.getTaskName() + "," + task.getStatus() + "," + task.getDescription() + "," ;
        }
        return taskToString;
    }

    public static Task toTask(String str){
        String [] values = str.split(",");
        int id = Integer.parseInt(values[0]);
        TaskType type = TaskType.valueOf(values[1]);
        String name = values[2];
        STATUS status = STATUS.valueOf(values[3]);
        String description = values[4];

        if (type.equals(TaskType.TASK)){
            return new Task(id, name, description, status);
        }else if (type.equals(TaskType.EPIC)){
            return new Epic(id, name, description, status);
        }else {
            int epicId = Integer.parseInt(values[5]);
            return new SubTask(id, name, description, status, epicId);
        }
    }

    public static String historyToString(List<Task> taskHistory){
       return taskHistory.stream()
                .map(Task::getTaskId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}

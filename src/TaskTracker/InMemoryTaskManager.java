package TaskTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private static HashMap<Integer, Task> allTasks = new HashMap<>();


    private static HashMap<Integer, Task> taskMap = new HashMap<>();
    private static HashMap<Integer, Epic> epicMap = new HashMap<>();
    private static HashMap<Integer, SubTask> subtaskMap = new HashMap<>();
    protected static List <Task> historyList = new ArrayList<>();

    public List <Task> history(){
        if (historyList.size() > 10) {
            historyList.remove(0);
        }
        return historyList;
    }

    public Task get(Integer integer) {
        allTasks.clear();
        allTasks.putAll(taskMap);
        allTasks.putAll(epicMap);
        allTasks.putAll(subtaskMap);
        historyList.add(allTasks.get(integer));
        return allTasks.get(integer);
    }


    public void getAllTasks() {
        allTasks.clear();
        allTasks.putAll(taskMap);
        allTasks.putAll(epicMap);
        allTasks.putAll(subtaskMap);
        for (Task t : allTasks.values()) {
            System.out.println(t);
        }
    }

    //For Tasks
    public void addTask(Task task) {
        task.setId(Task.getId() + 1);
        task.setTaskId(Task.getId());
        taskMap.put(task.getTaskId(), task);
        allTasks.put(task.getTaskId(), task);
    }

    public void getTasks() {
        for (Task t : taskMap.values()) {
            System.out.println(t.toString());
        }
    }

    public void updateTask(Task task, Integer id) {
        taskMap.get(id).setStatus(task.getStatus());
        taskMap.get(id).setTaskName(task.getTaskName());
        taskMap.get(id).setDescription( task.getDescription());
    }

    public void clearTasks() {
        taskMap.clear();
    }

    public void deleteTask(Integer id) {
        taskMap.remove(id);
    }


    //For Epics
    public void addEpic(Epic epic) {
        epic.setId(Task.getId() + 1);
        epic.setTaskId(Task.getId());
        epicMap.put(epic.getTaskId(), epic);
        allTasks.put(epic.getTaskId(), epic);
        updateEpic(epic, epic.getTaskId());
    }

    public void getEpics() {
        for (Task t : epicMap.values()) {
            System.out.println(t.toString());
        }
    }

    public void updateEpic(Epic epic, Integer id) {
        epicMap.get(id).setTaskName(epic.getTaskName());
        epicMap.get(id).setDescription(epic.getDescription());
        //epicMap.get(id).status= task.status;

        boolean statusNew = true;
        if (epic.getSubs() == null) {
            epicMap.get(id).setStatus(STATUS.NEW);
        } else {
            for (SubTask s : epic.getSubs()) {
                if (s.getStatus() != STATUS.NEW) {
                    statusNew = false;
                    break;
                }
            }
            if (statusNew) {
                epicMap.get(id).setStatus(STATUS.NEW);
            }
        }

        boolean statusDone = true;
        for (SubTask s : epic.getSubs()) {
            if (s.getStatus() != STATUS.DONE) {
                statusDone = false;
                break;
            }
        }
        if (statusDone && !statusNew) {
            epicMap.get(id).setStatus(STATUS.DONE);
        } else if (!statusDone && !statusNew) epicMap.get(id).setStatus(STATUS.IN_PROGRESS);
    }

    public void clearEpics() {
        epicMap.clear();
    }

    public void deleteEpic(Integer id) {
        for (SubTask s : epicMap.get(id).getSubs()) {
            subtaskMap.remove(s.getTaskId());
        }
        epicMap.remove(id);
    }

    public void showSubs(Epic epic) {
        System.out.println(epic.getSubs());
    }

    public void showSubs(Integer id) {
        System.out.println(epicMap.get(id).getSubs());
    }


    //For Subs
    public void addSubs(SubTask subTask) {
        subTask.setId(Task.getId() + 1);
        subTask.setTaskId(Task.getId());
        subTask.getParent().getSubs().add(subTask);
        updateEpic(subTask.getParent(), subTask.getParent().getTaskId());
        subtaskMap.put(subTask.getTaskId(), subTask);
        allTasks.put(subTask.getTaskId(), subTask);
    }

    public void getSubs() {
        for (Task t : subtaskMap.values()) {
            System.out.println(t.toString());
        }
    }

    public void updateSub(SubTask task, Integer id) {
        subtaskMap.get(id).setTaskName(task.getTaskName());
        subtaskMap.get(id).setDescription(task.getDescription());
        subtaskMap.get(id).setStatus(task.getStatus());

        if (!subtaskMap.get(id).getParent().equals(task.getParent())) {
            subtaskMap.get(id).getParent().getSubs().remove(subtaskMap.get(id));
        }
        subtaskMap.get(id).setParent(task.getParent());
        updateEpic(task.getParent(), task.getParent().getTaskId());
    }

    public void clearSubs() {
        subtaskMap.clear();
    }

    public void deleteSub(Integer id) {
        subtaskMap.get(id).getParent().getSubs().remove(subtaskMap.get(id));
        subtaskMap.remove(id);
    }


}

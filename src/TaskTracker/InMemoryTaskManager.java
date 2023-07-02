package TaskTracker;

import java.util.HashMap;
import java.util.Objects;

public class InMemoryTaskManager implements TaskManager {
    protected static HashMap<Integer, Task> allTasks = new HashMap<>();

    protected static HashMap<Integer, Task> taskMap = new HashMap<>();
    protected static HashMap<Integer, Epic> epicMap = new HashMap<>();
    protected static HashMap<Integer, SubTask> subtaskMap = new HashMap<>();

    protected static final HistoryManager historyManager = Managers.getDefaultHistory();

    public Task get(Integer integer) {
        allTasks.clear();
        allTasks.putAll(taskMap);
        allTasks.putAll(epicMap);
        allTasks.putAll(subtaskMap);
        historyManager.addHistoryTask(allTasks.get(integer));

        return allTasks.get(integer);
    }


    public void getAllTasks() {

        allTasks.clear();
        allTasks.putAll(taskMap);
        allTasks.putAll(epicMap);
        allTasks.putAll(subtaskMap);
        for (Task t : allTasks.values()) {
            historyManager.addHistoryTask(t);
            System.out.println(t);
        }
    }

    //For Tasks
    public void addTask(Task task) {
        if(!taskMap.containsValue(task)){
            task.setGlobalId(Task.getGlobalId() + 1);
            task.setTaskId(Task.getGlobalId());
            taskMap.put(task.getTaskId(), task);
        }
        //allTasks.put(task.getTaskId(), task);
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
        historyManager.remove(id);
    }


    //For Epics
    public void addEpic(Epic epic) {
        epic.setGlobalId(Task.getGlobalId() + 1);
        epic.setTaskId(Task.getGlobalId());
        epicMap.put(epic.getTaskId(), epic);
        //allTasks.put(epic.getTaskId(), epic);
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
        //epicMap.get(id).status = task.status;

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
            historyManager.remove(s.getTaskId());
        }
        epicMap.remove(id);
        historyManager.remove(id);

    }

    public void showSubs(Epic epic) {
        System.out.println(epic.getSubs());
    }

    public void showSubs(Integer id) {
        System.out.println(epicMap.get(id).getSubs());
    }


    //For Subs
    public void addSubs(SubTask subTask) {
        Epic epic = epicMap.get(subTask.getEpicId());
        subTask.setGlobalId(Task.getGlobalId() + 1);
        subTask.setTaskId(Task.getGlobalId());
        epic.getSubs().add(subTask);
        updateEpic(epic, epic.getTaskId());
        subtaskMap.put(subTask.getTaskId(), subTask);
        //allTasks.put(subTask.getTaskId(), subTask);
    }

    public void getSubs() {
        for (Task t : subtaskMap.values()) {
            System.out.println(t.toString());
        }
    }

    public void updateSub(SubTask task, Integer id) {
        Epic epic = epicMap.get(task.getEpicId());
        Epic epic2 = epicMap.get(subtaskMap.get(id).getEpicId());
        subtaskMap.get(id).setTaskName(task.getTaskName());
        subtaskMap.get(id).setDescription(task.getDescription());
        subtaskMap.get(id).setStatus(task.getStatus());

        if (!Objects.equals(subtaskMap.get(id).getEpicId(), task.getEpicId())) {
            epic2.getSubs().remove(subtaskMap.get(id));
        }
        subtaskMap.get(id).setEpicId(task.getEpicId());
        updateEpic(epic, task.getEpicId());
    }

    public void clearSubs() {
        subtaskMap.clear();
    }

    public void deleteSub(Integer id) {
        Epic epic = epicMap.get(subtaskMap.get(id).getEpicId());
        epic.getSubs().remove(subtaskMap.get(id));
        subtaskMap.remove(id);
        historyManager.remove(id);
    }


}

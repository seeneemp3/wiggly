package TaskTracker;

public interface TaskManager {
    Task get(Integer integer);
    void getAllTasks();
    void addTask(Task task);
    void getTasks();
    void updateTask(Task task, Integer id);
    void clearTasks();
    void deleteTask(Integer id);
    void addEpic(Epic epic);
    void getEpics();
    void updateEpic(Epic epic, Integer id);
    void clearEpics();
    void deleteEpic(Integer id);
    void showSubs(Epic epic);
    void showSubs(Integer id);
    void addSubs(SubTask subTask);
    void getSubs();
    void updateSub(SubTask task, Integer id);
    void clearSubs();
    void deleteSub(Integer id);



}

package TaskTracker;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Задача 1", "описание...");
        Task task2 = new Task("Задача 2", "описание...");

        Epic epic = new Epic("Эпик 1", "описание...");
        Epic epic1 = new Epic("Эпик 2", "описание...");


        SubTask subTask = new SubTask("СабТаска 0", "описание...", epic, STATUS.DONE);
        SubTask subTask1 = new SubTask("СабТаска 1", "описание...", epic, STATUS.DONE);
        SubTask subTask2 = new SubTask("СабТаска 2", "описание...", epic1, STATUS.DONE);


        InMemoryTaskManager manager = new InMemoryTaskManager();

        manager.addTask(task1);
        manager.addTask(task2);



        manager.addEpic(epic);
        manager.addSubs(subTask);
        manager.addSubs(subTask1);

        manager.addEpic(epic1);
        manager.addSubs(subTask2);

        //manager.getAllTasks();

        manager.get(1);
        manager.get(2);
        manager.get(1);
        manager.get(3);
        manager.get(1);
        manager.get(2);
        manager.get(1);
        manager.get(3);
        manager.get(1);
        manager.get(1);
        manager.get(1);
        //System.out.println( manager.history().size());
        InMemoryHistoryManager a = new InMemoryHistoryManager();
        System.out.println(a.getHistory());


        //manager.getEpics();

    }
}

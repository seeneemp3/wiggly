package TaskTracker;

public class Main {
    public static void main(String[] args) {

        InMemoryTaskManager manager = new InMemoryTaskManager();
        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();

        Task task1 = new Task("Задача 1", "описание...");
        Task task2 = new Task("Задача 2", "описание...");
        Task task3 = new Task("Задача 2", "описание...");
        Task task4 = new Task("Задача 2", "описание...");
        Task task5 = new Task("Задача 2", "описание...");
        Task task6 = new Task("Задача 2", "описание...");


        Epic epic = new Epic("Эпик 1", "описание...");
        Epic epic1 = new Epic("Эпик 2", "описание...");


        SubTask subTask = new SubTask("СабТаска 0", "описание...", epic, STATUS.DONE);
        SubTask subTask1 = new SubTask("СабТаска 1", "описание...", epic, STATUS.DONE);
        SubTask subTask2 = new SubTask("СабТаска 2", "описание...", epic1, STATUS.DONE);



        manager.addTask(task1);
//        manager.addTask(task2);
//        manager.addTask(task3);
//        manager.addTask(epic);
//        manager.addTask(epic1);
//        manager.addTask(subTask);
//        manager.addTask(task4);
//        manager.addTask(subTask1);
//        manager.addTask(subTask2);
//        manager.addTask(task5);
//        manager.addTask(task6);
        manager.get(1);

        System.out.println(manager.get(1));

        System.out.println(historyManager.getHistory());





    }
}

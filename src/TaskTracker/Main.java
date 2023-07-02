package TaskTracker;

import java.io.File;

import static TaskTracker.FileBackedTaskManager.readFromFile;

public class Main {
    public static void main(String[] args) {

        InMemoryTaskManager manager = new InMemoryTaskManager();
        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
        readFromFile(new File("data/BackedTasks.csv"));
        FileBackedTaskManager manager1 = new FileBackedTaskManager(new File("data/BackedTasks.csv"));


//        Task task1 = new Task("Задача 1", "описание...");
//        Epic epic = new Epic("Эпик 1", "описание...");
//        Epic epic1 = new Epic("Эпик 2", "описание...");
//
//        manager1.addTask(task1);
//        manager1.addEpic(epic);
//        manager1.addEpic(epic1);
//
//        SubTask subTask = new SubTask("СабТаска 0", "описание...", epic.getTaskId(), STATUS.DONE);
//        SubTask subTask1 = new SubTask("СабТаска 1", "описание...", epic1.getTaskId(), STATUS.DONE);
//        SubTask subTask2 = new SubTask("СабТаска 2", "описание...", epic1.getTaskId(), STATUS.DONE);
//
//        manager1.addSubs(subTask);
//        manager1.addSubs(subTask1);
//        manager1.addSubs(subTask2);

//        manager.addTask(epic);
//        manager.addTask(epic1);
//        manager.addTask(subTask);
//        manager.addTask(task4);
//        manager.addTask(subTask1);
//        manager.addTask(subTask2);
//        manager.addTask(task5);
//        manager.addTask(task6);


//        System.out.println(manager1.get(1));
//        System.out.println(manager1.get(2));
//        System.out.println(manager1.get(4));
//        System.out.println(manager.get(3));
//        System.out.println(manager1.get(5));

        System.out.println("History:");
        for (Task t : historyManager.getHistory()){
            System.out.println(t);
        }

//        manager.deleteEpic(1);
//        System.out.println("History:");
//        for (Task t : historyManager.getHistory()){
//            System.out.println(t);
//        }

    }
}

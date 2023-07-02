package TaskTracker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TaskTracker.CSVConverter.historyToString;

public class FileBackedTaskManager extends InMemoryTaskManager implements TaskManager{

    File filename;
    public FileBackedTaskManager (File filename){
        this.filename = filename;
    }

    public void save (){
        final FileBackedTaskManager taskManager = new FileBackedTaskManager(filename);
        try (BufferedWriter buffWriter = new BufferedWriter( new FileWriter(filename, StandardCharsets.UTF_8,false))){
            buffWriter.write("id,type,name,status,description,epic\n");
            for (Task t : taskMap.values()){
                buffWriter.write(CSVConverter.toString(t)+"\n");
            }
            for (Task t : epicMap.values()){
                buffWriter.write(CSVConverter.toString(t)+"\n");
            }
            for (Task t : subtaskMap.values()){
                buffWriter.write(CSVConverter.toString(t)+"\n");
            }

            buffWriter.write("History"+ historyToString(historyManager.getHistory()));



        }catch (IOException e){
            e.printStackTrace();
        }



    }

    public static FileBackedTaskManager readFromFile(File file){
        final FileBackedTaskManager taskManager = new FileBackedTaskManager(file);
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(file))){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        for (int i = 1; i < lines.size() - 2; i++) {
            String taskLine = lines.get(i);
                Task task = CSVConverter.toTask(taskLine);
                if (task.getType().equals(TaskType.TASK)) {
                    taskMap.put(task.getTaskId(), task);
                } else if (task.getType().equals(TaskType.EPIC)) {
                    epicMap.put(task.getTaskId(), (Epic) task);
                } else if (task.getType().equals(TaskType.SUBTASK)) {
                    subtaskMap.put(task.getTaskId(), (SubTask) task);
                }
        }
        Arrays.stream(lines.get(lines.size() - 1).split(",")).forEach(id -> {
           int parsedId = Integer.parseInt(id);
           if(taskMap.containsKey(parsedId)){
               historyManager.addHistoryTask(taskMap.get(parsedId));
           } else if(epicMap.containsKey(parsedId)){
               historyManager.addHistoryTask(epicMap.get(parsedId));
            } else if(subtaskMap.containsKey(parsedId)) {
               historyManager.addHistoryTask(subtaskMap.get(parsedId));
           }
        }
           );



        return taskManager;
    }

    @Override
    public Task get(Integer integer) {
        save();
        return super.get(integer);
    }

    @Override
    public void getAllTasks() {
        save();
        super.getAllTasks();
    }

    @Override
    public void addTask(Task task) {
        super.addTask(task);
        save();
    }

    @Override
    public void getTasks() {
        super.getTasks();
    }

    @Override
    public void updateTask(Task task, Integer id) {
        super.updateTask(task, id);
        save();
    }

    @Override
    public void clearTasks() {
        super.clearTasks();
        save();
    }

    @Override
    public void deleteTask(Integer id) {
        super.deleteTask(id);
        save();
    }

    @Override
    public void addEpic(Epic epic) {
        super.addEpic(epic);
        save();
    }

    @Override
    public void getEpics() {
        super.getEpics();
    }

    @Override
    public void updateEpic(Epic epic, Integer id) {
        super.updateEpic(epic, id);
        save();
    }

    @Override
    public void clearEpics() {
        super.clearEpics();
        save();
    }

    @Override
    public void deleteEpic(Integer id) {
        super.deleteEpic(id);
        save();
    }

    @Override
    public void showSubs(Epic epic) {
        super.showSubs(epic);
    }

    @Override
    public void showSubs(Integer id) {
        super.showSubs(id);
    }

    @Override
    public void addSubs(SubTask subTask) {
        super.addSubs(subTask);
        save();
    }

    @Override
    public void getSubs() {
        super.getSubs();
    }

    @Override
    public void updateSub(SubTask task, Integer id) {
        super.updateSub(task, id);
        save();
    }

    @Override
    public void clearSubs() {
        super.clearSubs();
        save();
    }

    @Override
    public void deleteSub(Integer id) {
        super.deleteSub(id);
        save();
    }
}

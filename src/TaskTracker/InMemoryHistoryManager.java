package TaskTracker;

import java.util.List;

import static TaskTracker.InMemoryTaskManager.historyList;

public class InMemoryHistoryManager implements HistoryManager {
    @Override
    public void addHistoryTask(Task task) {

    }

    @Override
    public void remove(int id) {
        historyList.remove(id);
    }

    @Override
    public List<Task> getHistory() {
        if (historyList.size() > 10) {
            historyList.remove(0);
        }
        return historyList;

    }
}

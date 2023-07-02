package TaskTracker;

import practice.TestLinkedList;

import java.util.*;

//import static TaskTracker.InMemoryTaskManager.historyList;

public class InMemoryHistoryManager implements HistoryManager {
    private final Map <Integer, CustomLList.Node<Task>> nodesMap = new HashMap<>();
    protected static CustomLList <Task> linkedTaskList = new CustomLList<>();

    @Override
    public void addHistoryTask(Task task) {
        CustomLList.Node <Task> node = null;

        if (task != null) {
            node = linkedTaskList.linkLast(task);
        }
        if (nodesMap.containsKey(task.getTaskId())) {
            linkedTaskList.removeNode(nodesMap.get(task.getTaskId()));
            nodesMap.put(task.getTaskId(), node);
        } else {
            nodesMap.put(task.getTaskId(), node);

        }
    }

    @Override
    public void remove(int id) {
        if (nodesMap.containsKey(id)){
            linkedTaskList.removeNode(nodesMap.get(id));
            nodesMap.remove(id);
        }
    }

    @Override
    public  List<Task> getHistory() {
        return linkedTaskList.getTasks();
    }

    private static class CustomLList <T extends Task>{

        Node <T> head;
        Node <T> tail;
        private int size = 0;

        static class Node <T extends Task> {
            Node <T> next;
            Node <T> prev;
            Task task;

            public Node(Task task) {
                this.task = task;
            }

            @Override
            public int hashCode() {
                return Objects.hash(task);
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if ( obj == null  || obj.getClass() != this.getClass()) return false;
                Node <?> node = (Node<?>) obj;
                return Objects.equals(node.task, task);
            }
        }

        private Node <T> linkLast(Task task) {
            Node <T> newNode = new Node <T> (task);
            if (size == 0) {
                newNode.next = null;
                newNode.prev = null;
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;
            size++;

            return tail;
        }

        private List <Task> getTasks(){
            List<Task> taskList = new ArrayList<>();
            Node <T> node = head;
            Node <T> node2 = tail;
            while (node != null){
                taskList.add(node.task);
                node = node.next;
            }
            return taskList;
        }

        private void removeNode(Node <T> node){
            if (node.next != null) {
                node.next.prev = node.prev;
            }else tail = node.prev;
            if (node.prev != null) {
                node.prev.next = node.next;
            }else head = node.next;
            size--;
        }
    }










}

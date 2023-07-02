package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestLinkedList {

    public static List <CustomLList.Node> listOfNodes = new ArrayList<>();


    public static void main(String[] args) {
        CustomLList <String> customList = new CustomLList<>();
        customList.linkLast("1");
        customList.linkLast("2");
        customList.linkLast("3");
        customList.linkLast("4");
        System.out.println(customList.getTasks());
        customList.removeNode(listOfNodes.get(2));
        System.out.println(customList.getTasks());

    }



    public static class CustomLList <String>  {
        Node head;
        Node tail;
        public int size = 0;

        class Node{
            Node next;
            Node prev;
            String element;

            public Node(String element) {
                this.element = element;
            }

            @Override
            public int hashCode() {
                return Objects.hash(next,prev,element);
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if ( obj == null  || obj.getClass() != this.getClass()) return false;
                Node node = (Node) obj;
                return Objects.equals(node.element, element);
            }
        }


        private Node linkLast(String element) {
            Node newNode = new Node(element);
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
            listOfNodes.add(tail);
            return tail;
        }

        public List<String> getTasks(){
            List<String> taskList = new ArrayList<>();
            Node node = head;
            while (node != null){
                taskList.add(node.element);
                node = node.next;
            }
            return taskList;
        }

        private void removeNode(Node node){
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

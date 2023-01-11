
package data;

import java.util.LinkedList;

public class SLL<T extends Comparable<T>>{

    Node<T> head, tail;

    public SLL() {
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(T el) {
        Node<T> p = new Node<T>(el);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head; 
            head = p;
        }

    }

    void printAll() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.next;
        }
    }


    //add last
    void addLast(T last) {
        Node<T> p = new Node<T>(last);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p; //tim pre
            tail = p;   //tim next
        }
    }

    //add in n pos
    void addPos(int pos, T value) {
        Node<T> p = new Node<T>(value);
        if (isEmpty()) {
            pos = 0;
            head = tail = p;
        } else {
            Node<T> pre = head;
            for (int i = 0; i < pos - 1; i++) {
                pre = pre.next; //tim pre
            }
            Node<T> after = pre.next; //tim next
            p.next = after;
            pre.next = p;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("nothing to delete");
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("nothing to delete");
        } else {
            Node<T> pre = head;
            Node<T> temp = pre.next;
            while (temp.next != null) {
                pre = pre.next;
                temp = pre.next;
            }
            pre.next = null;
            tail = pre;
        }
    }

    public void addMany(T arr[]){
        int i = 0;
        while (arr[i] != null){
            addLast(arr[i]);
            i++;
        }

    }
    //remove pos
    public void removePos(int pos) {
        if (isEmpty()) {
            System.out.println("Nothing to delete");
        } else {
            Node<T> pre = head;
            for (int i = 0; i < pos - 1; i++) {
                pre = pre.next;
            }
            Node<T> delete = pre.next;
            Node<T> after = delete.next;
            pre.next = after;
        }
    }

    public void removeAll() {
        if (isEmpty()) {
            System.out.println("Nothing to print");
        } else {
            for (Node<T> p = head; p != null;) {
                Node<T> next = p.next;
                p = null;
                p = next;
            }
            head = tail = null;
        }
    }


    public int indexOf(T value) {
        int count = 1;
        Node tmp = head;
        while (tmp != null) {
            count++;
            if (tmp.value.equals(value)) {
                return count;
            }
            tmp = tmp.next;
        }
        return -1;
    }

//    public int indexOf(T value) {
//        if (isEmpty()) {
//            System.out.println("nothing to search");
//        } else {
//            Node<T> temp = head;
//            int index = 0;
//            while( temp != null){
//                if (value.compareTo(temp.getValue()) == 0){
//                    return index;
//                }
//                index++;
//                temp = temp.next;
//            }
//        }
//        return -1;
//    }
    
    public void getSize(){
        if(isEmpty()){
            System.out.println("no data to get size");
        }else{
            Node<T> p = head;
            int count = 0;
            while (p != null) {                
                count ++;
                p = p.next;
            }
            System.out.println("The size is: " + count);
        }
    }



}

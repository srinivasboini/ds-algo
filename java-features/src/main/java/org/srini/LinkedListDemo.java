package org.srini;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("srinivas") ;
        linkedList.add("vas");
        linkedList.add("boini1");
        linkedList.add("boini2");
        linkedList.add("boini3");
        linkedList.add("boini4");
        linkedList.add("boini5");
        linkedList.add("boini6");

        System.out.println(linkedList.findKthElementFromEnd(5).getData());



    }


}


class LinkedList<E>{

    Node<E> head;
    Node<E> tail;
    int size;

    LinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void add(E element){
        Node<E> newNode = new Node<>(element);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            //we have elements already  1 -> [ head -> 1 , tail -> 1]  2-> [ tail ->2 , tail.next null, head.next -> tail]
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node<E> get(int index){
        //validation
        if(index==0){
            return this.head;
        }

        Node<E> currentNode = this.head;
        for(int i=0; i<index; i++){
            currentNode = currentNode.getNext() ;
        }

        return currentNode;

    }


    public Node<E> remove(int index){
        //validation
        if(index==0){
            removeFirst();
        }


        Node<E> prevNode = get(index - 1); //[0,1,2]   -> for 2 nd item -> get the 1st item
        Node<E> targetNode = prevNode.getNext() ;
        prevNode.next = targetNode.next;
        size--;
        return targetNode;
    }

    private void removeFirst() {
        Node<E> firstElement = this.head;
        this.head = firstElement.next ;
    }

    private void removeLast() {
        Node<E> lastElement = this.tail;
        this.head = lastElement.next ;
    }


    public boolean isEmpty(){
        return this.head == null;
    }

    public Node<E> findKthElementFromEnd(int index){


        int targetIndex = size - index ;
        if(targetIndex < 0 || targetIndex > size){
            return  null;
        }

        Node<E> currentNode = this.head;
        for(int i=0; i<targetIndex; i++){
            currentNode = currentNode.getNext();
        }
        return  currentNode;
    }






    static class Node<E>{
        E element;
        Node<E> next;

        Node(E element){
            this.element = element;
            this.next = null;
        }

        void setData(E element){
            this.element = element;
        }

        E getData(){
            return this.element;
        }

        Node<E> getNext(){
            return next;
        }

    }
}

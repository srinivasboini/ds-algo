package org.srini;

public class CustomLinkedListDemo {

    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("srinivas");
        customLinkedList.add("vas");
        customLinkedList.add("boini");

        System.out.println(customLinkedList);
        System.out.println(customLinkedList.get(2));
    }
}

class CustomLinkedList<E> {

    Node<E> head ;

    CustomLinkedList(){
        this.head = null;
    }

    void add(E data){
        Node<E> currentNode = null;
        if(head == null){
            this.head = new Node<>(data);
        }else{
             currentNode= this.head;
            while(currentNode.nextNode !=null){
                currentNode = currentNode.nextNode ;
            }
            currentNode.nextNode = new Node<>(data) ;
        }


    }

    E get(int index){
        Node<E> current = this.head;
        for(int i=0; i< index; i++){
            current = current.nextNode ;
        }
        return current.getData();
    }

    void remove(int index){
        Node<E> current = this.head;
        Node<E> previous = null ;
        for(int i=0; i< index; i++){
            previous = current;
            current = current.nextNode ;
        }


    }



    static class Node<E>{
        E data ;
        Node<E> nextNode ;

        Node(E data){
            this.data = data;
            this.nextNode = null;
        }

        E getData(){
            return data;
        }
    }
}

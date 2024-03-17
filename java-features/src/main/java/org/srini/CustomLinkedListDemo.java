package org.srini;

public class CustomLinkedListDemo {

    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("srinivas");
        customLinkedList.add("vas");

        System.out.println(customLinkedList);
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

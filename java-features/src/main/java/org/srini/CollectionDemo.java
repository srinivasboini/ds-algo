package org.srini;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayDeque<>() ;

        queue.offer("srinivas");
        queue.offer("boini");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        System.out.println(queue.size());

        Deque<String> deque = new ArrayDeque<>();
        deque.offer("srinivas");
        deque.offerFirst("boini");
        deque.offerLast("hi");

        while (!deque.isEmpty()){
            System.out.println(deque.poll());
        }

        System.out.println(deque.size());
    }
}



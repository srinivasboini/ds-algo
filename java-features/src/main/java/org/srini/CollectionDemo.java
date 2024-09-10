package org.srini;

import java.util.*;

import java.util.*;
import java.util.concurrent.*;

public class CollectionDemo {

    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedQueue<>() ;

        queue.offer("srinivas");
        queue.offer("boini");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        System.out.println(queue.size());

        // Note: ConcurrentLinkedQueue does not have the functionality of Deque,
        // so we cannot replace Deque with ConcurrentLinkedQueue directly.
        // If you still need to use Deque functionality, you may need to use another thread-safe Deque implementation.
    }
}



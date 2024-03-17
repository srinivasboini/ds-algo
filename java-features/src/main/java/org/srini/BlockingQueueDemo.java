package org.srini;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class BlockingQueueDemo {

    private static final ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10) ;
    public static void main(String[] args) {

        new Thread(() -> {
            IntStream
                    .range(0,5)
                    .forEach(e -> {
                        try {
                            System.out.println("Producing "+e);
                            arrayBlockingQueue.put(e);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
        }).start();

        new Thread(() -> {
            try {
                while (true){
                    Integer e = arrayBlockingQueue.take();
                    System.out.println("Consumed "+e);
                }



            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }
}

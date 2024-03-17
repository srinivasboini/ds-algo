package org.srini;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomHashMapDemo {

    public static void main(String[] args) {
        CustomHashMap<String, String> customHashMap = new CustomHashMap<>();

        customHashMap.put("Hi", "how");
        customHashMap.put("Hello", "Im good");
        customHashMap.put("demo", "demo") ;
        System.out.println(customHashMap);
        customHashMap.remove("demo");
        System.out.println(customHashMap);

        IntStream.range(0,20).mapToObj(i -> "demo"+i).forEach(e -> customHashMap.put(e,e));
        System.out.println(customHashMap);
    }
}

class CustomHashMap<K,V>{

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    int capacity;
    double loadFactor;
    int size;

    //declare the buckets to hold the Entry elements

    private ArrayList<Entry<K,V>>[] buckets ;

    CustomHashMap(){
        this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    CustomHashMap(int capacity, double loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        size=0;
        buckets = new ArrayList[capacity];
        //initialize all buckets
        for(int i=0; i<this.capacity; i++){
            buckets[i] = new ArrayList<>() ;
        }

    }


    public void put(K key, V value){
        //validation of keys
        //calculate hashcode and find bucket location based on capacity
        //TODO resizing logic
        //check if the size is more than the load factor i.e 0.75


        int index = getIndex(key) ;
        buckets[index].add(new Entry<>(key,value)) ;
        size ++;

        if( (double) size / capacity > loadFactor){
            resize();
        }

    }


    public void resize(){
        //rehash and recreate all buckets
        capacity = capacity * 2 ;
        ArrayList<Entry<K,V>>[] newBucket = new ArrayList[capacity];

        for(int i=0; i<capacity; i++){
            newBucket[i] = new ArrayList<>();
        }

        Arrays
                .stream(buckets)
                .flatMap(ArrayList::stream)
                .filter(Objects::nonNull)
                .forEach(e -> {
                    newBucket[getIndex(e.getKey())].add(e);
                });

        buckets = newBucket;

    }

    public V remove(K key){
        //validation key
        int index = getIndex(key) ;
        ArrayList<Entry<K,V>> currentBucket = buckets[index] ;

        Entry<K,V> entry =  currentBucket
                .stream()
                .filter(e -> e.getKey().equals(key))
                .findAny()
                .orElse(null) ;

        if(entry !=null){
            currentBucket.remove(entry);
            size--;
            return entry.getValue();
        }

        return  null;


    }

    @Override
    public String toString(){

       return Arrays
                .stream(buckets)
                .flatMap(ArrayList::stream)
                .map(Entry::toString)
                .collect(Collectors.joining(","));


    }


    public int getIndex(K key){
        int hashCode =    key.hashCode() ;
        int index = Math.abs(hashCode) % this.capacity ; // gives 0 to 15
        return index;
    }





    static class Entry<K,V>{
        final K key;
        final V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return value;
        }

        @Override
        public String toString(){
           return "["+key+","+value+"]" ;
        }



    }



}

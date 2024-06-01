package org.srini;

import java.util.Arrays;

public class CustomArrayListDemo {

    public static void main(String[] args) {

        String str = "srinivvas";
        System.out.println(str.replaceAll(".", "*"));

        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("srini");
        list.add("vas");

        System.out.println(list);

        list.add("boini");
        list.remove(0);
        System.out.println(list);
    }
}

class CustomArrayList<E> implements CustomList<E>{

    Integer DEFAULT_SIZE = 10;
    private Object[] elements;
    private Integer size;

    CustomArrayList(){
        elements = new Object[DEFAULT_SIZE];
        size = 0 ;
    }

    @Override
    public void add(E e) {

        elements[size++] = e;

        if(size == elements.length){
            increaseCapacity();
        }


    }

    private void increaseCapacity() {
        int newCapacity = DEFAULT_SIZE * 2 ;
        Object[] newElements = new Object[newCapacity];
        for(int i=0; i< elements.length; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public E remove(int index) {
        //check index valid or not
        if(index < 0 || index > elements.length){
            throw new IndexOutOfBoundsException("Index not valid");
        }

        //get the element from array
        E e = (E) elements[index];

        //shift the elements here
        for(int i=index; i< elements.length-1; i++){
            elements[i] = elements[i+1] ;
        }
        elements[elements.length -1] = null;
        size--;
        return (E) e;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append( "[");
        for(int i=0; i< size; i++){
            builder.append(elements[i]).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Integer size() {
        return size;
    }
}

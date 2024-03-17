package org.srini;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestFeature1 {

    @Test
    public void testCase1(){
        List<String> list = List.of("srini", "vas") ;

        List<String> arrList = new ArrayList<>() ;
        arrList.add("srini") ;
        arrList.add("vas") ;

        List<String> syncList = Collections.synchronizedList(list) ;

        System.out.println(syncList);
    }

    @Test
    public void testException(){
        try{
            System.out.println("try");
            String s = null ;

            s.length() ;

        }catch (Exception e){
            System.out.println("exception");
        }finally {
            System.out.println("finally");
        }
    }
}

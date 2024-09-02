package com.ds.java.search;

import java.util.Arrays;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        Integer[] a = {1,18, 29, 16, 27, 20, 11, 23, 244, 12};
        System.out.println("Value exists: " + linearSearch(a, 12));

        String[] s = {"Hello", "1", "2", "12"};
        System.out.println("Value exists: " + linearSearch(s, "121"));

        List list1  = Arrays.stream(a).toList();
        System.out.println("Value exists: " + linearSearch(list1, 12));

        List list2  = Arrays.stream(s).toList();
        System.out.println("Value exists: " + linearSearch(list2, "121"));
    }

    // linear search for Array [generic]
    public static <T> boolean linearSearch(T[] a, T key) {
        for (T t : a) {
            if (t.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // linear search for List
    public static <T> boolean linearSearch(List a, T key) {
        for(Object i: a){
            if(i.equals(key)){
                return true;
            }
        }
        return false;
    }
}

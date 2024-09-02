package com.ds.java.search;

import java.util.Arrays;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        // Array linear search
        Integer[] a = {1,18, 29, 16, 27, 20, 11, 23, 244, 12};
        boolean isPresent = linearSearch(a, 12);
        System.out.println("Value exists: " + isPresent);

        String[] s = {"Hello", "1", "2", "12"};
        boolean isPresent2 = linearSearch(s, "121");
        System.out.println("Value exists: " + isPresent2);

        List list1  = Arrays.stream(a).toList();
        boolean isPresent3 = linearSearch(list1, 12);
        System.out.println("Value exists: " + isPresent3);

        List list2  = Arrays.stream(s).toList();
        boolean isPresent4 = linearSearch(list2, "121");
        System.out.println("Value exists: " + isPresent4);
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

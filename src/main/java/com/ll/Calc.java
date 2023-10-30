package com.ll;

import java.util.*;

public class Calc {

    static int run(String str) {
        String[] arr = str.split(" ");
        ArrayList<String> list = new ArrayList<>(List.of(arr));
        if(list.contains("(")) removePair(list);
        return calc(list,0, list.size()-1);
    }

    static int calc(ArrayList<String> list, int start, int end){
        int a = Integer.parseInt(list.get(start));
        list.remove(start);
        if(start>=end) {
            return a;
        }
        String c = list.get(start);
        list.remove(start);
        if(c.equals("+")) {
            return a + calc(list, start , end-2);
        } else if(c.equals("-")){
            return a - calc(list, start , end-2);
        } else{
            multOrDiv(list, start, a, c);
            return calc(list,start, end-2);
        }
    }

    static void multOrDiv(ArrayList<String> list, int start, int a, String c) {
        int b = Integer.parseInt(list.get(start));
        if(c.equals("*")){
            list.set(start,a*b+"");
        } else {
            list.set(start,a/b+"");
        }
    }

    static void removePair(ArrayList<String> list){
        int now;
        int left = list.indexOf("(");
        list.remove(left);
        if(list.contains("(")) removePair(list);
        int right = list.indexOf(")");
        list.set(left,calc(list, left,right-1)+"");
    }
}

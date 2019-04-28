package com.example.ggfl.listsearch;

public class CheckTypos {

    public boolean isTypo(String s1, String s2){

        return (Math.abs(s1.length() - s2.length()) <= 1) &&  isOneChangeAway(s1, s2);
    }

    private boolean isOneChangeAway(String s1, String s2) {

        // I want a fixed one to be the bigger, in this case, s1. This saves some more complicated nested ifs later.
        if(! (s1.length() > s2.length())){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int nTypos = 0;
        for(int s1Pointer = 0, s2Pointer =0;s1Pointer<s1.length() && s2Pointer < s2.length() ;s1Pointer++, s2Pointer++){
            if(s1.charAt(s1Pointer) != s2.charAt(s2Pointer)){
                nTypos++;
                if(s1.length() > s2.length()){
                    s2Pointer--;
                }
            }
        }
        return nTypos <= 1;
    }
}


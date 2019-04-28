package com.example.ggfl.listsearch;

import java.util.HashMap;
import java.util.Map;

public class JumbledLetters {

    public boolean isPartialPermutation(String s1, String s2){

        return (s1.length() == s2.length()) &&  firstLetterHasntChanged(s1, s2) && ( (s1.length() <= 3 )  || (isPermutation(s1, s2) && lessThanTwoThirdsChanged(s1, s2)));
    }

    private boolean isPermutation(String s1, String s2) {
        Map<Character, Integer> dictonary = new HashMap<Character, Integer>();

        for (int i =0;i<s1.length();i++){
            if(dictonary.containsKey(s1.charAt(i))){
                dictonary.put(s1.charAt(i), dictonary.get(s1.charAt(i))+ 1);
            }
            else{
                dictonary.put(s1.charAt(i), 1);
            }
        }

        for(int i =0;i<s2.length();i++){
            if(dictonary.containsKey(s2.charAt(i))){
                dictonary.put(s2.charAt(i), dictonary.get(s2.charAt(i)) - 1);
            }
            else{
                return false;
            }
        }

        for(Integer i : dictonary.values()){
            if (i != 0){
                return false;
            }
        }

        return true;

    }

    private boolean lessThanTwoThirdsChanged(String s1, String s2) {
        float size = s1.length();
        float nNotChanged = 0;

        for (int i =0;i<s1.length();i++){
            if (s1.charAt(i) == s2.charAt(i)){
                nNotChanged++;
            }
        }
        float changed = size - nNotChanged;
        return changed/size <= 0.66;

    }

    private boolean firstLetterHasntChanged(String s1, String s2) {
        return s1.charAt(0) == s2.charAt(0);
    }

}

import java.util.HashMap;
import java.util.Map;

public class JumbledLetters {

    /*
        Our brain can read texts even if letters are jumbled, like the following sentence: “Yuo
        cna porbalby raed tihs esaliy desptie teh msispeillgns.” Given two words, write a
        method to decide if one is a partial-permutation of the other. Consider a
        partial-permutation only if:
        - The first letter hasn’t changed place
        - If the word has more than 3 letters, up to 2/3 of the letters have changed
        place
        Examples:
        you, yuo -> true
        probably, porbalby -> true
        despite, desptie -> true
        moon, nmoo -> false
        misspellings, mpeissngslli -> false
     */
    public static void main(String[] args){

        System.out.println(isPartialPermutation("    ", "    "));

    }

    public static boolean isPartialPermutation(String s1, String s2){

        return (s1.length() == s2.length()) &&  firstLetterHasntChanged(s1, s2) && ( (s1.length() <= 3 )  || (isPermutation(s1, s2) && lessThanTwoThirdsChanged(s1, s2)));
    }

    private static boolean isPermutation(String s1, String s2) {
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

    private static boolean lessThanTwoThirdsChanged(String s1, String s2) {
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

    private static boolean firstLetterHasntChanged(String s1, String s2) {
        return s1.charAt(0) == s2.charAt(0);
    }

}

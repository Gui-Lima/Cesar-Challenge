public class ReplaceCharacters {
    /*
 1. Replacing characters in place:
Given an array of characters, write a method to replace all the spaces with “&32”.
You may assume that the array has sufficient slots at the end to hold the additional
characters and that you are given the “true” length of the array. (Note: Please
perform this operation in the same array provided and without any String
methods).
Example:
Input: “User is not allowed “, 19
Output: “User&32is&32not&32allowed”

     */

    private static int lastDigit; // To pass less paramters between functions

    public static void main(String[] args){

        char[] test1 = {'a', ' ', 'a', 'r', 'a', 'r', 'a', ' ', 'a', 'z', 'u', 'l', ' ', ' ', ' ', ' '};
        char[] test2 = {'a', 'r', 'a', 'r', 'a', ' ', 'a', 'z', 'u', 'l', ' ', ' '};
        char[] test3 = {' ',' ',' '};
        char[] test4 = {' ', 'a',' ', ' '};
        char[] test5 = {' ', ' ', 'a',' ',' ',' ',' '};
        char[] test6 = {'a', 'r', 'a', 'r', 'a', ' ', 'a', 'z', 'u', 'l', ' ', ' ',' ', ' ',' '};

        replaceInPlace(test6);

    }

    public static char[] replaceInPlace(char[] s){

        lastDigit = findLastDigit(s);
        s = replaceEndSpaces(s);
        s = replaceMiddleSpaces(s);
        s = replaceStartingSpaces(s);
        print(s);
        return s;
    }

    private static char[] replaceStartingSpaces(char[] s) {
        //Remaining spaces that didn't have digits between them
        for(int i =0;i<s.length-1;i++){
            if (isSpace(s[i])) {
                s[i] = '&';
                s[i + 1] = '3';
                s[i + 2] = '2';
                i += 3;
            }
        }
        return s;
    }

    private static char[] replaceMiddleSpaces(char[] s) {
        boolean changeSpaceFlag = false;
        boolean changeCharactersFlag = true;
        int changePointer = s.length-1;

        // Finding the ideal point to the changepointer to be: right before the %32 I previously inserted
        while(s[changePointer] == '2' && s[changePointer-1] == '3' && s[changePointer-2] == '&'){
            changePointer -= 3;
        }

        int currentPointer = changePointer;

        for (int i = changePointer ; i >= 0; i--){

            // Swaping spaces between digits
            if (isSpace(s[i]) && changeSpaceFlag){
                s[changePointer] = '2';
                s[changePointer - 1] = '3';
                s[changePointer - 2] = '&';
                changeSpaceFlag = false;
                if (changePointer - 3 >= 0)
                    changeCharactersFlag = isSpace(s[changePointer -3]);
                changePointer -= 3;
            }


            if (!isSpace(s[i]) && changeCharactersFlag && changePointer >= 0){
                changeSpaceFlag = true;
                char temp = s[currentPointer];
                s[currentPointer] = s[changePointer];
                s[changePointer] = temp;
                changePointer--;
            }

            currentPointer --;
        }
        return s;
    }



    private static char[] replaceEndSpaces(char[] s) {

        int countEndSpaces = (s.length - lastDigit) - 1;

        if (countEndSpaces %2==0) return s;
        
        int countMiddleSpaces = 0;
        for(int i =0;i<=lastDigit;i++){
            if (isSpace(s[i])){
                countMiddleSpaces++;
            }
        }
        
        int shouldHaveSpaces = countMiddleSpaces * 3;
        int actualyHaveSpaces = countEndSpaces + countMiddleSpaces;
        int numberOfEndSpaces = (actualyHaveSpaces - shouldHaveSpaces)/3;
        
        for (int i =0,j=s.length-1;i<numberOfEndSpaces;i++){
            s[j] = '2';
            s[j-1] = '3';
            s[j-2] = '&';
            j -=3;
        }
        
        return s;
    }

    private static int findLastDigit(char[] s){
        int lastDigit = 0;
        for ( int i =s.length-1 ;i>=0;i--){
            lastDigit = i;
            if(!isSpace(s[i])) break;
        }
        return lastDigit;
    }

    private static void print(char[] s) {
        for (int i =0;i<s.length;i++){
            System.out.print(s[i]);
        }
        System.out.println();
    }

    private static boolean isSpace(char c) {
        int ascii = (int) c;
        return c < 33;
    }

}

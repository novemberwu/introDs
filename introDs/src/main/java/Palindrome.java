public class Palindrome {

    public static boolean isPalindrome(String str){
        int head = 0;
        int tail = str.length()-1;
        while ( head < tail){
            if(str.charAt(head) != str.charAt(tail)){
                return false;
            }
            head ++;
            tail --;
        }
        return true;

    }
}

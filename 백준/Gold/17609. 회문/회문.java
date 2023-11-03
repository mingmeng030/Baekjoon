import java.io.*;
import java.util.*;

public class Main {
    static String s;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            s = br.readLine();
            if(isPalindrome(0, s.length()-1)){
                System.out.println(0);
            }
            else{
                if(isPseudoPalindrome(0,s.length()-1)){
                    System.out.println(1);
                }
                else{
                    System.out.println(2);
                }
            }
        }
    }
 
    public static boolean isPalindrome(int left, int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
 
    public static boolean isPseudoPalindrome(int left, int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
               boolean removeFromLeft = isPalindrome(left+1,right);
               boolean removeFromRight = isPalindrome(left, right-1);
                
               if(!removeFromLeft && !removeFromRight) return false;
               else return true;
            }
            left++;
            right--;
        }
        return true;
    }
}
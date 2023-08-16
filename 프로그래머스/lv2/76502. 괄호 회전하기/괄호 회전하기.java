import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            if(isRight(s)) answer++;
            s = s.substring(1,s.length())+s.charAt(0);
        }
        return answer;
    }
    public boolean isRight(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(int j = 0; j<str.length(); j++){
            char c = str.charAt(j);
            if(stack.isEmpty()) stack.push(c);
            else if(c==')' && stack.peek()=='(') stack.pop();
            else if(c==']' && stack.peek()=='[') stack.pop();
            else if(c=='}' && stack.peek()=='{') stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty()? true : false;
    }
}
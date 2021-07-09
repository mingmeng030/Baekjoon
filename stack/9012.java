import java.util.Stack;
import java.util.Scanner;

class Main {
    String PS(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        answer = (stack.isEmpty()) ? "YES" : "NO";
        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num=s.nextInt();
        Mainone = new Main();
        for(int i=0; i<num; i++)
            System.out.println(one.PS(s.next()));
    }
}
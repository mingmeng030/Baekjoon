import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main{
    ArrayList<Integer>list;
    Main (){
        list=new ArrayList<Integer>();
    }
    void pushX(int num){
        list.add(num);
    }
    int pop(){
        if(list.isEmpty()) return -1;
        return list.remove(list.size()-1);
    }
    int size(){
        return list.size();
    }
    int empty(){
        int result=(list.size()==0)? 1 : 0;
        return result;
    }
    int top(){
        if(this.empty()==1) return -1;
        return list.get(list.size()-1);
    }
    public static void main(String []args) {
        BufferedReader BR = new BufferedReader(new InputStreamReader((System.in)));
        try {
            int n = Integer.parseInt(BR.readLine());
            Main newStack = new Main ();
            String input = "";
            while (n-- > 0) {
                input = BR.readLine();
                if (input.toLowerCase().contains("push")) {
                    int temp = Integer.parseInt(input.split(" ")[1]);
                    newStack.pushX(temp);
                } 
	else if (input.toLowerCase().contains("pop"))
                    System.out.println(newStack.pop());
                else if (input.toLowerCase().contains("size"))
                    System.out.println(newStack.size());
                else if (input.toLowerCase().contains("empty"))
                    System.out.println(newStack.empty());
                else if (input.toLowerCase().contains("top"))
                    System.out.println(newStack.top());
                else return;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
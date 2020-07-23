import java.util.*;
public class Main{
	static public class STACK{
		private int[] stack;
		private int top;
		
		public STACK() {
			top=-1;
			stack = new int[10000];
		}
		
		public void pushX(int X) {
			stack[++top]=X;
		}
		public int size() {
			return top+1;
		}

		public int empty() {
			if(top==-1) return 1;
			else return 0;
		}

		public int top() {
			if(empty()==1) return -1;
			else return stack[top];
		}
		
		public int pop() {
			int temp;
			if(empty()==1) return -1;
			temp=stack[top];
			stack[top--]=-1;
			return temp;	
		}

	}
		
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		STACK stack=new STACK();
		int x;
		int count=scan.nextInt();
		for(int i=0; i<count; i++) {
			String input=scan.next();
			if(input.contains("push")) {
				x=scan.nextInt();
				stack.pushX(x);
			}
			else if(input.contains("pop")) {
				System.out.printf("%d\n",stack.pop());
			}
			else if(input.contains("top")) 
				System.out.printf("%d\n",stack.top());				
			
			else if(input.contains("size")) 
				System.out.printf("%d\n",stack.size());
			
			else if(input.contains("empty")) {
				if(stack.empty()==1) System.out.println(1);
				else System.out.println(0);
				
			}
		}
		return ;
	}
}

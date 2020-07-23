import java.util.Scanner;
public class Main{
	static public class PS{
		Scanner scan1=new Scanner(System.in);
		private int[] stack;
		private int top;
		boolean flag=true;
		
		public PS() {
			top=-1;
			stack = new int[50];
		}
		public int empty() {
			if(top==-1) return 1;
			else return 0;
		}
		public void push(int X) {
			stack[++top]=X;
		}
		public int pop() {
			if(empty()==1) return -1;
			int temp=stack[top];
			stack[top--]=-1;
			return temp;	
		}
		public void check() {//문자열 입력 받아 괄호 체크
			Scanner scan1=new Scanner(System.in);
			String temp=scan1.nextLine();
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j)=='(') push(temp.charAt(j));
				else if(temp.charAt(j)==')') {
					if(empty()==0) pop();
					else {
						flag=false;
						break;
					}
				}
			}
			if(empty()==1&&flag) System.out.println("YES");
			else System.out.println("NO");
		}

		public static void main(String[] args) {
			Scanner scan2=new Scanner(System.in);
			int count=scan2.nextInt();
			for(int i=0; i<count; i++) {
				PS ps=new PS();
				ps.check();
			}
			return ;
		}
	}
}

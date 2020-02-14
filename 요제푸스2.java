package 백준_1월;
import java.util.*;
public class 요제푸스2{
	public static void main(String[] args) {
		Scanner scan2=new Scanner(System.in);
		int N=scan2.nextInt();
		int K=scan2.nextInt();
		StringBuilder SB = new StringBuilder();
		Vector<Integer> v=new Vector<Integer>();
		
		for(int i=1;i<=N ;i++) v.add(i);
		
		int now=K-1; //현재 위치==now
		while(true) {
			SB.append(v.get(now));
			v.remove(now);
			if(v.size()==0) break;
			SB.append(", ");
			now+=K-1;
			now%=v.size();
		}
		System.out.println("<"+SB+">");
	}
}
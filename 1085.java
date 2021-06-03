import java.util.*;
public class 직사각형에서_탈출 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		int w=scan.nextInt();
		int h=scan.nextInt();
		
		int left=x;
		int right=h-y;
		int up=w-x;
		int down=y;
		
		int[] temp= {left,right,up,down};
		int result=temp[0];
		for(int i=0; i<temp.length;i++) if(temp[i]<result) result=temp[i];
		
		System.out.println(result);
	}
}

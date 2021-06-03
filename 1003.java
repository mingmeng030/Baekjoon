import java.util.Scanner;
public class fibonacci {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] list=new int[41];
        int n, test;
        list[0]=0;
        list[1]=1;

        for(int i=2; i<=40; i++)
            list[i]=list[i-1]+list[i-2];

        test=s.nextInt();
        for(int i=0; i<test; i++){
            n=s.nextInt();
            if(n==0) System.out.println("1 0");
            else System.out.println(list[n-1]+" "+list[n]);
        }
    }
}

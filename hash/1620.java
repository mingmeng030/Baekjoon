import java.util.HashMap;
import java.util.Scanner;
public class Main{
    public static void main(String []args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String []arr=new String[N];
        
        for(int i=0; i<N; i++){
            String s= sc.next();
            arr[i]=s;
            map.put(s, i+1);
        }
        for(int i=0; i<M; i++){
            if(sc.hasNextInt()) System.out.println(arr[sc.nextInt()-1]);
            else System.out.println(map.get(sc.next()));
        }
    }
}

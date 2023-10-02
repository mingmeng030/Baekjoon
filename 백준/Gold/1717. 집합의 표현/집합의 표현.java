import java.io.*;
 
public class Main {
    static int[] root;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
 
        root = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            root[i] = i;
        }
 
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int flag = Integer.parseInt(line[0]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            
            int rootOfA = find(a);
            int rootOfB = find(b);

            if (flag == 0 && rootOfA!=rootOfB) union(rootOfA, rootOfB);
            else if(flag == 1){
                if(rootOfA == rootOfB) System.out.println("YES");
                else System.out.println("NO");
            } 
        }   
    }
 
    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }
 
    // y의 부모를 x의 부모로 치환
    public static void union(int x, int y) {
        root[x] = y;  
    }
}
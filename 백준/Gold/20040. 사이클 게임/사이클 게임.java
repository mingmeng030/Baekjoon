import java.io.*;
 
public class Main {
    static int[] root;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
 
        // 부모노드 자기 자신으로 초기화
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
 
        for (int i = 1; i <= M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            
            int rootOfA = find(a);
            int rootOfB = find(b);

            if(rootOfA==rootOfB){
                System.out.println(i);
                break;
            }
            else union(rootOfA, rootOfB);
                
            if(i==M) System.out.println(0);
        }
    }
 
    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }
 
    // x의 부모를 y의 부모로 치환
    public static void union(int x, int y) {
        root[x] = y;  
    }
}
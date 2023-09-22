import java.io.*;
 
public class Main {
	public static int N, M;	
	public static StringBuilder sb = new StringBuilder();
    public static int[] sequence;
	public static boolean[] check;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		sequence = new int[M];
		check = new boolean[N];
        
		dfs(1, 0);
		System.out.println(sb);
	}
    public static void dfs(int now, int count) {
		if (count == M) {
			for (int n : sequence) 
				sb.append(n).append(' ');
			sb.append('\n');
			return;
		}
 
		for (int i = now; i <= N; i++) {
			sequence[count] = i;
			dfs(i, count + 1);
		}
	}
}
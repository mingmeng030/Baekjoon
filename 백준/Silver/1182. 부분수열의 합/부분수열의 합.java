import java.io.*;
 
public class Main {
	public static int N, S;
    public static int result;
    public static int[] numArr;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		S = Integer.parseInt(line[1]);
        
        numArr = new int[N];
		line = br.readLine().split(" ");
        
		for (int i = 0; i < N; i++) {
		  numArr[i] = Integer.parseInt(line[i]);
		}

		dfs(0, 0);
        // S가 0이면 아무 것도 고르지 않는 경우가 result에 포함되므로 -1
		System.out.println(S == 0? result-1 : result);
	}
    public static void dfs(int sum, int nowIndex) {
        // 배열 끝까지 탐색 후 sum==S 이면 경우의 수 증가 후 return
        // sum!=S 이면 return 만
		if (nowIndex==N) {
            if(sum == S){
                result++;
            }
			return;
		}
 
        // 현재 인덱스를 부분수열에 포함하지 않는 경우, 포함하는 경우
        dfs(sum+numArr[nowIndex], nowIndex+1);
		dfs(sum, nowIndex+1);
	}
}
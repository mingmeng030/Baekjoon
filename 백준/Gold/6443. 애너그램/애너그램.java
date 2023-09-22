import java.io.*;
import java.util.*;
 
public class Main {
	static int N;
    static StringBuilder sb = new StringBuilder();
    static char[] wordArr = {'a','c','b','a'};

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
	
		for(int i=0;i<N;i++) {
		 	wordArr = br.readLine().toCharArray();
			
		 	Arrays.sort(wordArr);
		 	sb.append(wordArr).append('\n');
			
		 	while(next_permutation(wordArr.length))
		 		sb.append(wordArr).append('\n');
		}

		System.out.println(sb);
	}
    static boolean next_permutation(int n) {
		int idx = n - 1;
		
		while(idx > 0 && wordArr[idx] <= wordArr[idx - 1]) 
			idx--;
		
		if(idx == 0) return false;
		
		for(int i = n-1; i >= idx; i--) {
			if(wordArr[idx - 1] < wordArr[i]) {
				char temp = wordArr[i];
				wordArr[i] = wordArr[idx - 1];
				wordArr[idx - 1] = temp;
				break;
			}
		}
		
		Arrays.sort(wordArr, idx, n);
		return true;
	}
}
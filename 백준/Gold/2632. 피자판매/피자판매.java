import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int  N = Integer.parseInt(st.nextToken());
    int  M = Integer.parseInt(st.nextToken());
		
		int[] pizzaA = new int[N];
		int[] pizzaB = new int[M];
		
		int maxPizzaA = 0;
		int maxPizzaB = 0;
		
		for (int i = 0; i < N; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
			maxPizzaA += pizzaA[i];
		}
		
		for (int i = 0; i < M; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
			maxPizzaB += pizzaB[i];
		}
		
		// nCount : pizzaN을 통해 만들 수 있는 경우의 수
		// ex) testCase1의 경우(size 0을 만드는 경우의 수 1로 가정)
		// aCount : 1 1 3 1 2 1 1 2 0 0 0 0 0 0 1
		// 각 index에 해당하는 pizza size를 만드는 경우의 수이다.
		// -> index 2 : maxPizzaA에서 size가 2인 조각을 가져오는 방법
		int[] aCount = new int[Math.max(maxPizzaA, size)+1];
		aCount[0] = 1;
		aCount[maxPizzaA] = 1;
		count(pizzaA, aCount, size);
		
		int[] bCount = new int[Math.max(maxPizzaB, size)+1];
		bCount[0] = 1;
		bCount[maxPizzaB] = 1;
		count(pizzaB, bCount, size);
		
		int result = 0;
		for(int i = 0; i <= size; i++) {
			result += (aCount[i] * bCount[size - i]);
		}
		System.out.println(result);
  }
	
	public static void count(int[] pizza, int[] count, int size) {
		for(int i = 0; i < pizza.length; i++) { //시작하는 피자의 인덱스
			int sum = 0;
			for(int j = 1; j < pizza.length; j++) { //선택하는 피자 조각의 개수
				int nextPizza = pizza[(i + j) % pizza.length];
				if(sum + nextPizza > size) break;
				sum += nextPizza;
				count[sum]++;
			}
		}
	}
}
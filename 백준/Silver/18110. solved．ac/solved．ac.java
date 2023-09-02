import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] score = new int[count];
		
		for (int i = 0; i < count; i++) 
			score[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(score);
		int mean = (int) Math.round(count * 0.15); 
		
		int sum = 0;
		for (int i = 0; i < count; i++) {
			if (i < mean || i > count-mean-1) continue;
			sum += score[i];
		}
		System.out.println((int) Math.round((double) sum / (count - mean * 2)));
	}
}
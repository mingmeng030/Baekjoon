import java.io.*;
import java.util.*;

class Main {
	static int[][] wheel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        wheel = new int[4][8];
        for(int i = 0; i<4; i++){
            String s = br.readLine();
            for(int j = 0; j<8; j++){
                wheel[i][j] = s.charAt(j) - '0';
            }
        }
        
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i<K; i++){
            String[] line = br.readLine().split(" ");
            int gearNum = Integer.parseInt(line[0])-1;
            int direction = Integer.parseInt(line[1]);
            
            // 회전 안함 0, 시계 1, 반시계 -1
            int[] rotation = new int[4];
            rotation[gearNum] = direction;
            
            // 회전할 톱니바퀴의 왼쪽 톱니바퀴 검사
			for (int j = 0; gearNum!=0 && j<gearNum; j++) {
                // j가 짝수면 다른 방향(-direction), 홀수면 같은 방향(direction)
				if (wheel[gearNum - j][6] != wheel[gearNum - j - 1][2])
					rotation[gearNum - j - 1] = j % 2 == 0 ? -direction : direction; 
				else break;
			}
 
            // 회전할 톱니바퀴의 오른쪽 톱니바퀴 검사
			for (int j = 0; gearNum != 3 && j < 4-gearNum-1; j++) {
                // j가 짝수면 다른 방향, 홀수면 같은 방향
				if (wheel[gearNum + j][2] != wheel[gearNum + j + 1][6])
					rotation[gearNum + j + 1] = j % 2 == 0 ? -direction : direction; 
				else break;
			}
 
			// 1: 시계방향 회전, -1 : 반시계방향 회전
			for (int j = 0; j < 4; j++) {
                if(rotation[j] == 1) clockwise(j);
                else if(rotation[j] == -1) counterclockwise(j);
			}
        }
        
        int result = 0;	// 점수
		for (int i = 0; i < 4; i++) {
			if(wheel[i][0] == 1){ // i번째 톱니바퀴 점수 : 2^i
                result += Math.pow(2, i);
            }
		}
		System.out.println(result);
    }
    
    public static void counterclockwise(int n) { // 반시계 방향
		int temp = wheel[n][0];
        // 하나씩 왼쪽으로 밀고 마지막 인덱스에 0번에 있던 문자 넣어주기
		for (int i = 0; i <= 6; i++)
			wheel[n][i] = wheel[n][i + 1];
		wheel[n][7] = temp;
	}
    
 	public static void clockwise(int n) { // 시계방향
		int temp = wheel[n][7];
        // 하나씩 오쪽으로 밀고 0번 인덱스에 마지막에 있던 문자 넣어주기
		for (int i = 6; i >= 0; i--)
			wheel[n][i + 1] = wheel[n][i];
		wheel[n][0] = temp;
	}
}
import java.util.*;
import java.io.*;

public class Main{
	static int seats[][];
	static HashMap<Integer,Integer[]> preferenceMap=new HashMap<>();
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
    
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		seats=new int[n][n];
		
		for(int i=0; i<n*n; i++){
            String[] line = br.readLine().split(" ");
            int student = Integer.parseInt(line[0]);
            preferenceMap.put(student, new Integer[] {
                Integer.parseInt(line[1]),
                Integer.parseInt(line[2]),
                Integer.parseInt(line[3]),
                Integer.parseInt(line[4])
            });
            findSeat(student);
        }

        int preference = 0;
		for(int i=0;i<seats.length;i++) {
			for(int j=0;j<seats.length;j++) {
				
				int count = 0;
				Integer friends[] = preferenceMap.get(seats[i][j]);
				for(int k=0;k<4;k++) {
					int y=i+dy[k];
					int x=j+dx[k];
					if(x<0||y<0||y>=n||x>=n) continue;
					int now = seats[y][x];
					
					for(int m=0;m<4;m++)
						if(now == friends[m]) count++;
					
				}
                if(count==1) preference+=1;
                else if(count==2) preference+=10;
                else if(count==3) preference+=100;
                else if(count==4) preference+=1000;
			}
		}		
		System.out.println(preference);
	}
	public static void findSeat(int student) {
		Integer friends[] = preferenceMap.get(student);
		int f1 = friends[0];
		int f2 = friends[1];
		int f3 = friends[2];
		int f4 = friends[3];
		
		ArrayList<Integer[]> list=new ArrayList<>();
		for(int i=0;i<seats.length;i++) {
			for(int j=0;j<seats.length;j++) {
				int friend = 0, empty = 0;
				for(int k=0;k<4;k++) {
					int y=i+dy[k];
					int x=j+dx[k];
					if(x<0||y<0||y>=seats.length||x>=seats.length) continue;

					int now = seats[y][x];
					if(now==f1||now==f2||now==f3||now==f4) friend++;
					if(now==0) empty++;
					
				}
				list.add(new Integer[] {friend,empty,i,j});
				
			}
		}
		Collections.sort(list,new Comparator<>() {
			@Override
			public int compare(Integer n1[],Integer n2[]) {
				if(n1[0]<n2[0]) return 1;
				else if(n1[0]==n2[0]) {
					if(n1[1]<n2[1]) return 1;
					else if(n1[1]==n2[1]) {
						if(n1[2]>n2[2]) return 1;
						else if(n1[2]==n2[2]) {
							if(n1[3]>n2[3]) return 1;
						}
						
					}
				}
				return -1;
			}
		});
		
		for(int i=0;i<list.size();i++) {
			int y = list.get(i)[2];
			int x = list.get(i)[3];
			if(seats[y][x]==0) {
				seats[y][x] = student;
				return;
			}
			
		}
	}
}
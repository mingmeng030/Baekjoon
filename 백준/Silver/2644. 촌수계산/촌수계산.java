import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static List<Integer>[] relations; 
    static boolean[] checked; 
    static int totalPeople,totalRelation,person1, person2;
    static int result = -1;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        totalPeople = Integer.parseInt(br.readLine());
        relations = new ArrayList[totalPeople+1]; 
        checked = new boolean[totalPeople+1]; 
        for(int i=1; i<totalPeople+1; i++) {
			relations[i] = new ArrayList<>();
		}
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());
        
		totalRelation= Integer.parseInt(br.readLine());        
        

        for(int i = 0; i < totalRelation; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
            relations[x].add(y);
            relations[y].add(x);
        }
        
        dfs(person1, 0);
        System.out.println(result);
    }

    public static void dfs(int start, int count) {
        if(start==person2){
            result=count;
            return;
        }
        checked[start] = true;
        for(int i = 0; i < relations[start].size(); i++) {
            int next = relations[start].get(i);
            if(checked[next] == false){
                dfs(next, count+1);
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main{
	static class Node{
		int point, time;
		public Node(int point, int time) {
			this.point = point;
			this.time = time;
		}
		public int getPoint() {
			return point;
		}
		public int getTime() {
			return time;
		}
	}
    
	static int N,K;
	static boolean[] check;	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	int size = Math.max(N, K);
        
    	if(size == N) System.out.println(N-K);	
        else {
        	check = new boolean[100001];
        	System.out.println(dijkstra(N,K));
        }
    }

    static int dijkstra(int start, int end) {
         /*
        현재 정점들에서 거리가 가장 적은 정점을 바로 poll() 가능하도록 
        시간이 작은 순으로 Queue에 저장되도록 Comparator를 설정
        */
    	PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {	
			@Override
			public int compare(Node o1, Node o2) {
				return o1.time - o2.time;
			}
		});
    	queue.add(new Node(start,0));	//수빈이의 위치 큐에 저장
    	check[start] = true;		//수빈이의 위치 탐색 완료
    	int result = Integer.MAX_VALUE;	//최소 시간 값 초기화
        
    	while(!queue.isEmpty()) {
    		Node now = queue.poll();
    		int point = now.getPoint();
    		int time = now.getTime();
            
    		if(point==end) { //동생 위치와 같아지면 min으로 최소 시간 갱신
    			result = Math.min(time, result);
    			continue;
    		}
    		else check[point] = true;
            
    		if(point*2 <= 100000 && !check[point*2]) { //*2
    			queue.add(new Node(point*2, time));
    		}
        	if(point < end && !check[point+1]) { // +1
        		queue.add(new Node(point+1, time +1));
        	}
        	if(point > 0 && !check[point-1]) {	//-1
         		queue.add(new Node(point-1, time + 1));
        	}   
   	
    	}
    	return result;
    }
}
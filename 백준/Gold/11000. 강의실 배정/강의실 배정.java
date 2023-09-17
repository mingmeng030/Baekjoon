import java.util.*;
import java.io.*;
class Main {

    static int N;
    static int[][] classes;

    public static void main(String[] args) throws IOException {

        inputData();

        Arrays.sort(classes, Comparator.comparingInt((int[] t) -> t[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(classes[0][1]);

        for (int i=1; i<N; i++) {

            if (classes[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(classes[i][1]);
        }

        System.out.println(minHeap.size());
    }

    private static void inputData() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        classes = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<2; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
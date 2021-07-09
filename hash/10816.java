import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //10
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] s = br.readLine().split(" "); //input 정수

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(s[i]);
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num, 1);
        }

        int m = Integer.parseInt(br.readLine()); //8
        s = br.readLine().split(" "); //output 정수
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(s[i]);
            if(map.containsKey(num)) sb.append(map.get(num));
            else sb.append("0");
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
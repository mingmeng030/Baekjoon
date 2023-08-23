import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String s= br.readLine();

        boolean flag = false;
        String word = "";
        for(int i=0; i<s.length(); i++){
            String now = s.substring(i,i+1);
            if(now.equals("<")){
                sb.append(word);
                word = "";
                flag = true;
                sb.append("<");
            }
            else if(now.equals(">")){
                flag = false;
                sb.append(">");
            }
            else if(flag==true) sb.append(now);
            else if(flag==false){
                if(now.equals(" ")){
                    sb.append(word);
                    sb.append(" ");
                    word = "";
                }
                else word = now + word;
            }
        }
        sb.append(word);
        System.out.println(sb);
    }
}
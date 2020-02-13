import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int horse=0;
        String[] chess=new String[8];
        for(int i=0; i<8; i++) chess[i]=scan.nextLine();
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(i%2==0&&j%2==0&&chess[i].charAt(j)=='F') horse++;
                else if(i%2==1&&j%2==1&&chess[i].charAt(j)=='F') horse++;
                else continue;
            }
        }
        System.out.println(horse);
    }
}

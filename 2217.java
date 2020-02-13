import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan1=new Scanner(System.in);
        int n=scan1.nextInt(); //로프개수=n
        int[] temp1=new int[n];    //for문 내에서 임시로 매번 로프 길이를 입력 받을 변수
        int rope=0;    //로프 길이
        int num=0;    //arraylist temp2에서 가장 큰 중량을 가질 수 있는 로프의 인덱스
        ArrayList<Integer> temp2= new ArrayList<Integer>();
        //각 로프 선택 시 최대 중량을 저장할 arraylist
 
        for(int i=0; i<n;i++) temp1[i]=scan1.nextInt();
        //for문으로 n개의 로프 길이를 배열 temp1에 저장
        Arrays.sort(temp1); //오름차순 정렬
        //각 로프 선택 시 최대 중량을 temp2에 저장하고 가장 큰 중량의 인덱스를 num에 저장
        for(int i=0; i<n;i++) {
            temp2.add(temp1[i]*(n-i));
            if(temp2.get(i).intValue()>rope) {
                rope=temp1[i]*(n-i);
                num=i;
            }
        }
        int w=temp2.get(num).intValue();
        System.out.println(w);
    }
}

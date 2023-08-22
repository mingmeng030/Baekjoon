import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0,min = 0;
        Arrays.sort(people);
        for (int max = people.length-1; min <= max; max--){
            if(people[max]+people[min]<=limit){
                min++;
            }
            answer++;
        }
        return answer;
    }
}
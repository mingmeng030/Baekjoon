package B;
import java.util.Scanner;

public class queue {
    static public class Q {
        private int[] queue;
        private int back;
        private int front;

        public Q() {
            queue = new int[10000];
            back = -1;
            front = -1;
        }

        public void pushX(int X) {
            queue[++back] = X;
        }

        public int size() {
            return back-front;
        }

        public int empty() {
            if (back==front) return 1;
            else return 0;
        }
        //O front==back이 항상 empty임을 정의하기 위해
        //todo front는 항상 비어있는 칸으로 간주한다.
        //note front+1 번째 칸에 첫 번째 큐의 요소가 들어있다.
        public int front() {
            if (empty()==1) return -1;
            else return queue[front + 1];
        }

        public int back() {
            if (empty()==1) return -1;
            else return queue[back];
        }

        public int pop() {
            if (empty()==1) return -1;
            int temp = queue[front + 1];
            queue[front + 1] = -1;
            front++;
            return temp;
        }
    }
    public static void main(String[] args){
        Scanner scan3=new Scanner(System.in);
        System.out.println();
        Q queue=new Q();
        int count=scan3.nextInt();

        for(int i=0; i<count; i++) {
            String input=scan3.next();

            if(input.contains("push")) {
                int x=scan3.nextInt();
                queue.pushX(x);
            }
            else if(input.contains("pop"))
                System.out.printf("%d\n",queue.pop());
            else if(input.contains("front"))
                System.out.printf("%d\n",queue.front());
            else if(input.contains("back"))
                System.out.printf("%d\n",queue.back());
            else if(input.contains("size"))
                System.out.printf("%d\n",queue.size());
            else if(input.contains("empty")) {
                if(queue.empty()==1) System.out.println(1);
                else System.out.println(0);
            }
        }
        return ;
    }
}

//todo 안녕하세요
//note 인텔리제이
//O 주석 색깔 변경 소개글 입니다.
//X IntelliJ-remark color customizing!



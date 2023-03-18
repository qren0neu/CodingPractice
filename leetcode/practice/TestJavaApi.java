import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestJavaApi {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> eq = new LinkedList<>();
        eq.pollFirst()
        eq = new ArrayList<>();

        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o1 - o2;
            }
        };

        Comparator<Integer> cp2 = (o1, o2) -> o1 - o2;
        
        
    }
}

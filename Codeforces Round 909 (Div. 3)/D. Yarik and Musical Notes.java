import java.util.*;

public class Main {
    public static class Pair {
        long first, second;
        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            long n = sc.nextLong();
            Vector<Long> list = new Vector<>();
            for (int i = 0; i < n; ++i) {
                list.add(sc.nextLong());
            }
            HashMap<Long, Long> map1 = new HashMap<>();
            HashMap<Long, Long> map2 = new HashMap<>();
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                int count = 0;
                int Ist = 0;
                long curr = list.get(i);
                while(curr>0) {
                    if (curr % 2 == 1) count++;
                    Ist++;
                    curr = curr >> 1;
                }
                if(count == 1) {
                    ans += map1.getOrDefault((list.get(i) - Ist), 0L);
                    map1.put(list.get(i) - Ist, map1.getOrDefault((list.get(i) - Ist), 0L) + 1);
                } 
                else{
                    ans += map2.getOrDefault(list.get(i), 0L);
                    map2.put(list.get(i), map2.getOrDefault(list.get(i), 0L) + 1);
                }
            }

            System.out.println(ans);
        }
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        Map<Integer, Long> cache = new HashMap<>();
        long maxGold = getMaxGold(n, cache);
        System.out.println(maxGold);
    }
    
    public static long getMaxGold(int n, Map<Integer, Long> cache) {
        if (n == 0) {
            return 0;
        }
        
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        long maxGold = Math.max(n, getMaxGold(n/2, cache) + getMaxGold(n/3, cache) + getMaxGold(n/4, cache));
        cache.put(n, maxGold);
        return maxGold;
    }
}

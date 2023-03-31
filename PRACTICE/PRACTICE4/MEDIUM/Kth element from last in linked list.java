
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int value = sc.nextInt();
        while (value != -1) {
            list.add(value);
            value = sc.nextInt();
        }
        int k = sc.nextInt();
        int p1 = 0;
        int p2 = k;
        while (p2 < list.size()) {
            p1++;
            p2++;
        }
        System.out.println(list.get(p1));
    }
}

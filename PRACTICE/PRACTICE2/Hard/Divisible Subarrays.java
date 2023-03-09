/*You are given N elements, a1,a2,a3….aN. Find the number of good sub-arrays.
A good sub-array is a sub-array [ai,ai+1,ai+2….aj] such that (ai+ai+1+ai+2+….+aj) is divisible by N*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] freq = new int[n];
            freq[0] = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
                sum = ((sum % n) + n) % n;
                freq[sum]++;
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (freq[i] * (freq[i] - 1)) / 2;
            }
            System.out.println(ans);
        }
    }
}

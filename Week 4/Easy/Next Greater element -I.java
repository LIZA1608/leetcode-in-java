import java.util.*;
public class Main {
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length]; // array to store the next greater elements
        Stack<Integer> stack = new Stack<>(); // stack to store elements in descending order

        // Iterate through the array in reverse
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from stack until a greater element is found
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If a greater element is found, store it in the result array
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element to the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // input size of array
        int[] nums = new int[n]; // input array

        // input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = nextGreaterElement(nums); // calculate next greater elements
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " "); // print the next greater elements
        }
    }
}

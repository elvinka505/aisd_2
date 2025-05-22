package aisd.hometask.task4;

import java.util.Arrays;

public class Task4 {
    public static int maxNumbers(int[] nums, int s) {
        Arrays.sort(nums);
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= s) {
                sum += num;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {15, 5, 11, 10, 12};
        int s = 30;
        System.out.println(maxNumbers(nums, s)); //3
    }
}
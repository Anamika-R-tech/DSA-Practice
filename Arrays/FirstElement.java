import java.util.*;

public class FirstElement {

    public static int findUnique(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Traverse original array
        // and find the first element with frequency 1
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1};

        System.out.println(findUnique(nums));
    }
}
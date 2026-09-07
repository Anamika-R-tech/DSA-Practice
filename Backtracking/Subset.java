import java.util.*;

public class Subset{

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        func(0, result, new ArrayList<>(), nums);

        return result;
    }

    public static void func(
            int idx,
            List<List<Integer>> result,
            List<Integer> current,
            int[] nums) {

        result.add(new ArrayList<>(current));

        for (int i = idx; i < nums.length; i++) {

            current.add(nums[i]);

            func(i + 1, result, current, nums);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = subsets(nums);

        System.out.println(result);

        sc.close();
    }
}
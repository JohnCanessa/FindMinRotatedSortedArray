import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;


/**
 * 
 */
public class FindMinRotatedArray {


    /**
     * Given the sorted rotated array nums of unique elements,
     * return the minimum element of this array.
     * Implements brute force approach.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 38.2 MB, less than 78.96% of Java online submissions.
     */
    static int findMin0(int[] nums) {
        
        // **** sanity check ****
        if (nums.length == 1)
            return nums[0];

        // **** initialization ****
        int min = nums[0];

        // **** ****
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }

        // **** return min element ****
        return min;
    }


    /**
     * Given the sorted rotated array nums of unique elements,
     * return the minimum element of this array.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 38.2 MB, less than 64.79% of Java online submissions.
     */
    static int findMin(int[] nums) {
        
        // **** sanity check(s) ****
        if (nums.length == 1)
            return nums[0];

        // **** initialization ****
        int left    = 0;
        int right   = nums.length - 1;

        // **** check if there is no rotation ****
        if (nums[right] > nums[left])
            return nums[left];

        // **** binary search approach ****
        while (left < right) {

            // **** compute mid point ****
            int mid = left + (right - left) / 2;

            // **** check if we found min ****
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            // **** decide which way to go ****
            if (nums[mid] > nums[0]) {
                left = mid + 1;                 // go right
            } else {
                right = mid - 1;                // go left
            }
        }

        // **** min not found ****
        return -1;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        // **** read and create input array ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** find and display min ****
        System.out.println("main <<< output: " + findMin0(nums));

        // **** find and display min ****
        System.out.println("main <<< output: " + findMin(nums));
    }
}
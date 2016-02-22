package three_sum_closest;

import java.util.Arrays;

public class Solution {
  /**
   * @param numbers: Give an array numbers of n integer
   * @param target : An integer
   * @return : return the sum of the three integers, the sum closest target.
   */
  public int threeSumClosest(int[] numbers, int target) {
    if (numbers == null || numbers.length < 3) {
      return target;
    }

    Arrays.sort(numbers);

    int rst = numbers[0] + numbers[1] + numbers[2];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length - 2; i++) {
      int left = i + 1;
      int right = numbers.length - 1;
      while (left < right) {
        int sum = numbers[i] + numbers[left] + numbers[right];
        if (sum == target) {
          return target;
        } else if (sum > target) {
          if (sum - target < min) {
            min = sum - target;
            rst = sum;
          }
          right--;
        } else {
          if (target - sum < min) {
            min = target - sum;
            rst = sum;
          }
          left++;
        }
      }
    }

    return rst;
  }
}

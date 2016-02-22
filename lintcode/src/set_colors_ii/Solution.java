package set_colors_ii;

class Solution {
  /**
   * @param colors: A list of integer
   * @param k: An integer
   * @return: nothing
   */
  public void sortColors2(int[] colors, int k) {
    if (colors == null || colors.length < 2) {
      return;
    }
    int start = 0;
    int end = colors.length - 1;
    int count = 0;

    while (count < k) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = start; i <= end; i++) {
        min = Math.min(min, colors[i]);
        max = Math.max(max, colors[i]);
      }

      int left = start;
      int right = end;
      int curr = left;
      while (curr <= right) {
        if (colors[curr] == min) {
          swap(colors, left, curr);
          left++;
          curr++;
        } else if (colors[curr] == max) {
          swap(colors, right, curr);
          right--;
        } else {
          curr++;
        }
      }

      count += 2;
      start = left;
      end = right;
    }
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}

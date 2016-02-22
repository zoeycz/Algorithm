package sort_letters_by_case;

public class Solution {
  /**
   * @param chars: The letter array you should sort by Case
   * @return: void
   */
  public void sortLetters(char[] chars) {
    if (chars == null || chars.length < 2) {
      return;
    }
    int left = 0;
    int right = chars.length - 1;
    while (left < right) {
      while (Character.isLowerCase(chars[left]) && left < right) {
        left++;
      }
      while (Character.isUpperCase(chars[right]) && left < right) {
        right--;
      }
      if (left < right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
      }
    }
  }
}


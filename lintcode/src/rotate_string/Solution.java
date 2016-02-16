package rotate_string;

public class Solution {
  /**
   * @param str: an array of char
   * @param offset: an integer
   * @return: nothing
   */
  public void rotateString(char[] str, int offset) {
    if (str == null || str.length == 0) {
      return;
    }

    // Note: offset can be any value
    offset = offset % str.length;
    if (offset == 0) {
      return;
    }
    reverse(0, str.length - offset - 1, str);
    reverse(str.length - offset, str.length - 1, str);
    reverse(0, str.length - 1, str);
  }

  private void reverse(int start, int end, char[] str) {
    if (start >= end)
      return;
    for (int i = start, j = end; i < j; i++, j--) {
      char tmp = str[i];
      str[i] = str[j];
      str[j] = tmp;
    }
  }
}

package restore_ip_address;

import java.util.ArrayList;

public class Solution {
  /**
   * @param s the IP string
   * @return All possible valid IP addresses
   */
  public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> res = new ArrayList<String>();
    if (s == null || s.length() == 0) {
      return res;
    }
    StringBuilder sb = new StringBuilder();
    helper(res, sb, s, 0);
    return res;
  }

  private void helper(ArrayList<String> res, StringBuilder sb, String s, int pos) {
    if (pos == 4 && sb.length() == s.length() + 4) {
      sb.delete(sb.length() - 1, sb.length());
      res.add(sb.toString());
      sb.append(".");
      return;
    }

    for (int i = sb.length() - pos + 1; i <= s.length() && i < sb.length() - pos + 1 + 4; i++) {
      String ss = s.substring(sb.length() - pos, i);
      if (s.charAt(sb.length() - pos) == '0' && i > sb.length() - pos + 1) {
        continue;
      }
      if (Integer.valueOf(ss) <= 255 && Integer.valueOf(ss) >= 0) {
        sb.append(ss);
        sb.append(".");
        helper(res, sb, s, pos + 1);
        sb.delete(sb.length() - ss.length() - 1, sb.length());
      }
    }
  }
}

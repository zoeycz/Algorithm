package letter_combination_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * @param digits A digital string
   * @return all possible letter combinations
   */
  public ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> res = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
      return res;
    }

    // Note: concise way of construct map
    Map<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('0', new char[] {});
    map.put('1', new char[] {});
    map.put('2', new char[] {'a', 'b', 'c'});
    map.put('3', new char[] {'d', 'e', 'f'});
    map.put('4', new char[] {'g', 'h', 'i'});
    map.put('5', new char[] {'j', 'k', 'l'});
    map.put('6', new char[] {'m', 'n', 'o'});
    map.put('7', new char[] {'p', 'q', 'r', 's'});
    map.put('8', new char[] {'t', 'u', 'v'});
    map.put('9', new char[] {'w', 'x', 'y', 'z'});

    StringBuilder sb = new StringBuilder();
    helper(res, map, sb, digits);
    return res;
  }

  private void helper(ArrayList<String> res, Map<Character, char[]> map, StringBuilder sb,
      String digits) {
    if (sb.length() == digits.length()) {
      res.add(sb.toString());
      return;
    }

    // Note: how to get next c
    for (char c : map.get(digits.charAt(sb.length()))) {
      sb.append(c);
      helper(res, map, sb, digits);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}


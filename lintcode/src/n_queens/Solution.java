package n_queens;

import java.util.ArrayList;

class Solution {
  /**
   * Get all distinct N-Queen solutions
   * 
   * @param n: The number of queens
   * @return: All distinct solutions For example, A string '...Q' shows a queen on forth position
   */
  ArrayList<ArrayList<String>> solveNQueens(int n) {
    ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
    generate(rst, new ArrayList<Integer>(), n);
    return rst;
  }

  private void generate(ArrayList<ArrayList<String>> rst, ArrayList<Integer> cols, int n) {
    if (cols.size() == n) {
      convert(rst, cols);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isValid(cols, i)) {
        continue;
      }
      cols.add(i);
      generate(rst, cols, n);
      cols.remove(cols.size() - 1);
    }
  }

  private boolean isValid(ArrayList<Integer> cols, int col) {
    for (int i = 0; i < cols.size(); i++) {
      // check all rows
      if (cols.get(i) == col) {
        return false;
      }
      // check top right to bottom left
      if (i + cols.get(i) == col + cols.size()) {
        return false;
      }
      // check top left to bottom right
      if (i - cols.get(i) == cols.size() - col) {
        return false;
      }
    }
    return true;
  }

  private void convert(ArrayList<ArrayList<String>> rst, ArrayList<Integer> sol) {
    int n = sol.size();
    ArrayList<String> list = new ArrayList<String>();
    for (int x : sol) {
      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < n; i++) {
        if (i == x) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      list.add(sb.toString());
    }
    rst.add(list);
  }
}

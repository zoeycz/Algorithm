package first_bad_version;

/**
 * you can use SVNRepo.isBadVersion(k) to judge whether the kth code version is bad or not.
 */

class SVNRepo {
  public static boolean isBadVersion(int k) {
    return false;
  }
}


class Solution {
  /**
   * @param n: An integers.
   * @return: An integer which is the first bad version.
   */
  public int findFirstBadVersion(int n) {
    if (n <= 0) {
      return 0;
    }

    int start = 1;
    int end = n;
    int mid = (start + end) / 2;
    while (start + 1 < end) {
      if (SVNRepo.isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid;
      }
      mid = (start + end) / 2;
    }

    if (SVNRepo.isBadVersion(mid)) {
      return mid;
    } else if (SVNRepo.isBadVersion(end)) {
      return end;
    } else {
      return 0;
    }
  }
}


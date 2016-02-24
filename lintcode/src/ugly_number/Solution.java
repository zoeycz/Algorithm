package ugly_number;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  /**
   * @param k: The number k.
   * @return: The kth prime number as description.
   */
  public long kthPrimeNumber(int k) {
    Queue<Long> heap = new PriorityQueue<Long>();
    Map<Long, Boolean> map = new HashMap<Long, Boolean>();
    long[] primes = new long[3];
    primes[0] = 3;
    primes[1] = 5;
    primes[2] = 7;

    for (int i = 0; i < 3; i++) {
      heap.add(primes[i]);
      map.put(primes[i], true);
    }

    long curr = 0;
    for (int i = 0; i < k; i++) {
      curr = heap.poll();
      for (int j = 0; j < 3; j++) {
        long number = curr * primes[j];
        if (!map.containsKey(number)) {
          heap.add(number);
          map.put(number, true);
        }
      }
    }

    return curr;
  }
};

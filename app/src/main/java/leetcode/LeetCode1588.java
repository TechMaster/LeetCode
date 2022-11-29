package leetcode;

public class LeetCode1588 {
  public int sumOddLengthSubarrays(int[] arr) {
    int len = arr.length;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      for (int odd_len = 1; odd_len <= len - i; odd_len += 2) {
        for (int j = i; j < i + odd_len; j++) {
          sum += arr[j];
        }
      }
    }
    System.out.println(sum);
    return sum;
  }
}

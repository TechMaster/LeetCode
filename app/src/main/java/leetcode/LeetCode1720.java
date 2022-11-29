package leetcode;

public class LeetCode1720 {
  public int[] decode(int[] encoded, int first) {
    int[] arr = new int[encoded.length + 1];
    arr[0] = first;
    for (int i = 1; i < encoded.length + 1; i++) {
      // Inverse XOR
      // https://stackoverflow.com/questions/14279866/what-is-inverse-function-to-xor
      arr[i] = encoded[i - 1] ^ arr[i - 1];
    }
    return arr;
  }
}

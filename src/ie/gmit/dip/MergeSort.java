package ie.gmit.dip;

import java.util.Arrays;

class MergeSort implements SortingAlgorithm {

  public int[] sort(int[] array) {
    if (array.length > 1) {
      int[] firstHalf = sort(Arrays.copyOfRange(array,0, array.length / 2));
      int[] secondHalf = sort(Arrays.copyOfRange(array, array.length / 2, array.length));
      return merge(firstHalf, secondHalf);
    }

    return array;
  }

  private int[] merge(int[] array1, int[] array2) {
    int[] result = new int[array1.length + array2.length];
    int array1index = 0;
    int array2index = 0;
    for (int i = 0; i < result.length; i++) {
      if (array1index < array1.length && array2index < array2.length) {
        result[i] = array1[array1index] < array2[array2index]
            ? array1[array1index++] : array2[array2index++];
      } else if (array1index < array1.length) {
        result[i] = array1[array1index++];
      } else {
        result[i] = array2[array2index++];
      }
    }
    return result;

  }
}

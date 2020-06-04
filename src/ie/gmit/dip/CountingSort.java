package ie.gmit.dip;

import java.util.Arrays;

class CountingSort implements SortingAlgorithm {

  @Override
  public int[] sort(int[] array) {
    int[] result = new int[array.length];
    int[] countingArray = prepareCountingArray(array);

    for(int i = array.length - 1; i >= 0; i--) {
      int element = array[i];
      result[countingArray[element] - 1] = element;
      countingArray[element]--;
    }
    return result;
  }

  private int[] prepareCountingArray(int[] array) {
    int[] countingArray = new int[highestValue(array) + 1];
    Arrays.fill(countingArray, 0);

    for(int element : array) {
      countingArray[element]++;
    }

    for(int i = 1; i < countingArray.length; i++) {
      countingArray[i] += countingArray[i-1];
    }

    return countingArray;
  }

  private int highestValue(int[] array) {
    int result = -1;
    for (int element : array) {
      if (element > result) {
        result = element;
      }
    }
    return result;
  }
}

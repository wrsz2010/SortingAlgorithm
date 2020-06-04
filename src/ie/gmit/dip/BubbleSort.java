package ie.gmit.dip;

class BubbleSort implements SortingAlgorithm {

  public int[] sort(int[] array) {
    boolean changed;
    do {
      changed = false;
      for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          int temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
          changed = true;
        }
      }
    } while(changed);

    return array;
  }

}

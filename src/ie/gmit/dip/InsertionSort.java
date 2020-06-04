package ie.gmit.dip;

class InsertionSort implements SortingAlgorithm {

	  @Override
	  public int[] sort(int[] array) {
	    for(int i = 1; i < array.length; i++) {
	      for(int j = 0; j < i; j++) {
	        if(array[i] < array[j]) {
	          int element = array[i];
	          moveElements(array, j, i);
	          array[j] = element;
	        }
	      }
	    }
	    return array;
	  }

	  private void moveElements(int[] array, int from, int to) {
	    for(int i = to - 1; i >= from; i--) {
	      array[i+1]  = array[i];
	    }
	  }
	}

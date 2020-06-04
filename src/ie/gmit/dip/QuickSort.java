package ie.gmit.dip;

class QuickSort implements SortingAlgorithm {

	  @Override
	  public int[] sort(int[] array) {
	    sortSubArray(array, 0, array.length - 1);
	    return array;
	  }

	  private void sortSubArray(int[] array, int left, int right) {
	    int numberOfElements = right - left + 1;

	    if(numberOfElements == 2) {
	      if (array[left] > array[right]) {
	        swap(array, left, right);
	      }
	    } else {
	      int pivot = right;
	      int i = left;
	      while (i < pivot) {
	        if (array[pivot] < array[i]) {
	          if(i < pivot -1) {
	            swap(array, pivot, pivot - 1);
	          }
	          swap(array, pivot, i);
	          pivot--;
	        } else {
	          i++;
	        }
	      }
	      if(pivot - 1 - left >= 1) {
	        sortSubArray(array, left, pivot - 1);
	      }
	      if(right - (pivot + 1) >= 1) {
	        sortSubArray(array, pivot + 1, right);
	      }
	    }
	  }

	  private void swap(int[] array, int index1, int index2) {
	    int temp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = temp;
	  }

	}

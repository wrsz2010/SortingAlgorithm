package ie.gmit.dip;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SortingBenchmark {

	
  private static final int NUMBER_OF_SORTS = 10;

  
  // results are stored in array
  
  private static List<Double> bubbleSortResults = new ArrayList<>();
  private static List<Double> countingSortResults = new ArrayList<>();
  private static List<Double> insertionSortResults = new ArrayList<>();
  private static List<Double> mergeSortResults = new ArrayList<>();
  private static List<Double> quickSortResults = new ArrayList<>();

  public static void main(String... args) {

	  
	  
// Format and print table of results 
	  
    System.out.format("%-24s", "Array length:");
    
    
    // range of array size
    // I used range: 100 - 1250 step by 150
    //		  range: 1000 - 10000 step by 1000
    //		  range: 10000 - 1000000 step by 10000
    
    for (int i = 1000; i <= 10000; i += 1000) {
      System.out.format("%-14d", i);
      
      // generate array of specific size and bound of max value of integer is 200000
      
      int[] array = ArrayGenerator.generateArray(i, 200000);
      bubbleSortResults.add(averageSortingTime(array, new BubbleSort(), NUMBER_OF_SORTS));
      countingSortResults.add(averageSortingTime(array, new CountingSort(), NUMBER_OF_SORTS));
      insertionSortResults.add(averageSortingTime(array, new InsertionSort(), NUMBER_OF_SORTS));
      mergeSortResults.add(averageSortingTime(array, new MergeSort(), NUMBER_OF_SORTS));
      quickSortResults.add(averageSortingTime(array, new QuickSort(), NUMBER_OF_SORTS));
      
    }

    
    System.out.println();
    printResults(bubbleSortResults, "BubbleSort");
    printResults(countingSortResults, "CountingSort");
    printResults(insertionSortResults, "InsertionSort");
    printResults(mergeSortResults, "MergeSort");
    printResults(quickSortResults, "QuickSort");

  }

  private static long sortDuration(int[] array, SortingAlgorithm algorithm) {
	  
	  // make copy of original array for counting time
	  
    int[] arrayToSort = Arrays.copyOf(array, array.length);
    
    // set starting point array before sorting
    Instant start = Instant.now();
    int[] sortedArray = algorithm.sort(arrayToSort);
    
    // set stop - array after sorting
    Instant stop = Instant.now();
    
    // Duriation operates on nanosecond
    
    return Duration.between(start, stop).toMillis();
  }

  // This method counting sorting time and return average time
  
  private static double averageSortingTime(int[] array, SortingAlgorithm algorithm,
                                           int numberOfSorts) {
    double result = 0;
    for (int i = 0; i < numberOfSorts; i++) {
      result += sortDuration(array, algorithm);
    }
    return result / (double) numberOfSorts;
  }

  // this method print results to the table with precision of 0.000
  
    
  private static void printResults(List<Double> results, String label) {
    System.out.format("%-24s", label + ":");
    for (Double element : results) {
      System.out.format("%-14.3f", element);
    }
    System.out.println();
  }

}

package ie.gmit.dip;

import java.util.Random;

// interface for generating random arrays

interface ArrayGenerator {

  static int[] generateArray(int length, int valuesUpperBound) {
    int[] result = new int[length];
    Random element = new Random();

    
    // Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive), drawn from this random number generator's sequence. 
    // The general contract of nextInt is that one int value in the specified range is pseudorandomly generated and returned. All bound possible int values are produced with (approximately) 
    // equal probability. The method nextInt(int bound) is implemented by class Random.
    
    for(int i = 0; i < result.length; i++) {
      result[i] = element.nextInt(valuesUpperBound);
    }

    return result;
  }

}

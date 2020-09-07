package com.twc.javaBasic;

import com.twc.javaBasic.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTest {
  @Test
  void should_auto_resolve_generic_method() {
    final String[] words = {"Hello", "Good", "Morning"};

    // TODO:
    //  The getMiddle method is a generic method. Now, please call getMiddle method for string
    //  type.
    // <--start
    final String middle = getMiddle(words);
    // --end-->

    assertEquals("Good", middle);
  }

  @Test
  void should_specify_a_type_restriction_on_typed_parameters() {
    // Hint: please implement the min() method in this class.
    int minimumInteger = min(new Integer[] {1, 2, 3});
    double minimumReal = min(new Double[] {1.2, 2.2, -1d});

    assertEquals(1, minimumInteger);
    assertEquals(-1d, minimumReal, 1.0E-05);
  }

  @Test
  void should_swap() {
    Pair<String> pair = new Pair<>("Hello", "World");

    // Hint: please implement swap() method in this class.
    swap(pair);

    assertEquals("World", pair.getFirst());
    assertEquals("Hello", pair.getSecond());
  }

  private static <T> T getMiddle(T[] args) {
    return args[args.length / 2];
  }

  // TODO:
  //  please implement the following code to pass the test. It should be generic
  //  after all. The method should only accept `Number` and the number should
  //  implement `Comparable<T>`.
  //  You should not change the signature of the function. But you can change
  //  the declaration of the generic type parameter.
  // <--start
  private static <T extends Number & Comparable> T min(T[] values) {
    return Arrays.stream(values).min(new Comparator<T>() {
      @Override
      public int compare(T o1, T o2) {
        return o1.compareTo(o2);
      }
    }).get();
  }
  // --end-->

  // TODO:
  //  please implement following method to pass the test. The method should be able
  //  to swap fields in a pair. But you cannot change the signature of the function.
  //
  // Hint:
  //  A wildcard is not a type variable, so we can’t write code that uses ? as a type.
  // <--start
  private static void swap(Pair<?> pair) {
    swapHelper(pair);
  }

  // TODO: You can add additional method within the range if you like
  private static <T> void swapHelper(Pair<T> pair) {
    T template = pair.getFirst();
    pair.setFirst(pair.getSecond());
    pair.setSecond(template);
  }
  // --end-->
}

package hw;

import java.util.Arrays;
import java.util.Collections;

public class DescSort {
    public static void main(String[] args) {
        Integer[] numbers = { 5, 3, 8, 1, 9 };

        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.println("Sorted descending: " + Arrays.toString(numbers));
    }
}
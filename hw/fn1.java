package hw;

import java.util.ArrayList;
import java.util.Collections;

public class fn1 {
    public static void main(String[] args) {
        /**
         * create array list
         */

        ArrayList<String> programing = new ArrayList<>();

        // Add items to the List array
        programing.add("Java");
        programing.add("Dajango");
        programing.add("Node JS");
        programing.add("Rust");
        System.out.println("Programming Languages:");
        for (String lang : programing) {
            System.out.println(lang);
        }

        // add Item at last index of array list
        programing.add("Golang");
        System.out.println("Programming Languages:");
        for (String lang : programing) {
            System.out.println(lang);
        }
    }
}

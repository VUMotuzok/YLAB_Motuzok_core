package task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println(Arrays.toString(sort(array)));
    }

        public static int[] sort ( int[] array){
            for (int n = array.length; n > 1; n--) {
                for (int i = 1; i < n; i++) {
                    if (array[i - 1] > array[i]) {
                        int t = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = t;
                    }
                }
            }

            int[] sortArray = {1, 2, 3, 4, 5, 5, 6, 9};
            for (int i = 0; i < array.length; i++) {
                assert array[i] == sortArray[i];
            }
            return array;
        }
    }

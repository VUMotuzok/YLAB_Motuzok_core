package task1;

import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        int[] array = arrayRandom(15);
        System.out.println(Arrays.toString(array));
        System.out.println("Maximum number = " + numberMax(array)); //вывод макисимального значения из массива

    }

    //Задача 1. Заполните массив случайным числами и выведите максимальное,
    // минимальное и среднее значение.
    public static int[] arrayRandom(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * arrayLength);
        }
        return array;
    }

    public static int numberMax(int[] array) {
        int resultMax = array[0];
        for (int i : array) {
            if (i > resultMax) {
            }
                resultMax = i;
            }
        return resultMax;
    }
}

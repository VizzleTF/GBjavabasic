package Homeworks.lesson2;

import java.util.Arrays;
import java.util.Random;

public class hw {
    /*
    Задать целочисленный массив, состоящий из 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0
     */
    private static int[] hw1create(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            Random ran = new Random();
            array[i] = ran.nextInt(2) + 0;
        }
        return array;
    }

    private static int[] hw1reverse(int[] a) {
        int[] reverse = new int[a.length];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = 1- a[i];
        }
        return reverse;
    }

    /*
    Задать пустой целочисленный массив размером 8. Циклом заполнить его 0 3 6 9 12 15 18 21
     */

    private static int[] hw2(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        return array;
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    private static int[] hw3(int[] a) {
        int[] mod = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                mod[i] = a[i] * 2;
            } else {
                mod[i] = a[i];
            }
        }
        return mod;
    }

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
    */
    private static int[][] hw4(int length) {
        int[][] array = new int[length][length];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length -i -1] = 1;
        }
        return array;
    }
    /*
    5. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    */
    private static int[] hw5create(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            Random ran = new Random();
            array[i] = ran.nextInt(1000) + -500;
        }
        return array;
    }

    private static int[] hw5search(int[] array) {
        int min = array[0];
        int mini = 0;
        int max = array[0];
        int maxi = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                mini = i;
            } else if (array[i] > max) {
                max = array[i];
                maxi = i;
            }
        }
        return new int[]{maxi, mini, max, min};
    }
    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    **Примеры:
    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
    граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ
    */
    private static int[] hw6create(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            Random ran = new Random();
            // здесь задается рендж значений: первое число - количество значений, второе - минимальное значение.
            array[i] = ran.nextInt(3) + -1;
        }
        return array;
    }

    private static int[] hw6check(int[] a) {
        int left = a[0];
        int right = a[a.length - 1];
        int l = 1;
        int truth = 0;
        for (int i = 1; i < a.length - 1; i++) {
            right += a[i];
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (left != right) {
                left += a[i];
                right -= a[i];
                l++;
            } else {
                truth = 1;
            }
        }
        return new int[]{l, truth};
    }
    /*
    7. *** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево)
      -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    */
    private static int[] hw7create(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            Random ran = new Random();
            array[i] = ran.nextInt(1000) + -500;
        }
        return array;
    }

    private static int[] hw7moved(int[] a, int n) {
        n = n % a.length;
        n = a.length - n;
            for (int i = 0; i < n; i++) {
                int af = a[a.length - 1];
                for (int j = 1; j <= a.length - 1; j++) {
                    a[a.length - j] = a[a.length - j - 1];
                }
                a[0] = af;
            }
        return a;
    }




    public static void main(String[] args){

        System.out.println("hw1: ");
        int hw1length = 20;
        int[] hw1array = hw1create(hw1length);
        int[] hw1reverse = hw1reverse(hw1array);
        System.out.println("Original array: " + Arrays.toString(hw1array));
        System.out.println("Reversed array: " + Arrays.toString(hw1reverse));

        System.out.println("\n" + "hw2: ");
        int hw2length=8;
        int[] hw2array = hw2(hw2length);
        System.out.println("Array: " + Arrays.toString(hw2array));

        System.out.println("\n" + "hw2: ");
        int[] hw3array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] hw3modified = hw3(hw3array);
        System.out.println("Original array: " + Arrays.toString(hw3array));
        System.out.println("Modified array: " + Arrays.toString(hw3modified));

        System.out.println("\n" + "hw4: ");
        int hw4length=8;
        int[][] hw4array = hw4(hw4length);
        System.out.println(Arrays.deepToString(hw4array));

        System.out.println("\n" + "hw5: ");
        int hw5length=8;
        int[] hw5array = hw5create(hw5length);
        int[] hw5search = hw5search(hw5array);
        System.out.println("Array: " + Arrays.toString(hw5array));
        System.out.println("max is number: " + hw5search[0] + " - " + hw5search[2]);
        System.out.println("min is number: " + hw5search[1] + " - " + hw5search[3]);

        System.out.println("\n" + "hw6: ");
        int hw6length = 19;
        int[] hw6array = hw6create(hw6length);
        int[] hw6check = hw6check(hw6array);
        System.out.println("Original array: " + Arrays.toString(hw6array));
        if(hw6check[1] == 1) {
            System.out.println("With separator: " +Arrays.toString(Arrays.copyOfRange(hw6array,0,hw6check[0])) + Arrays.toString(Arrays.copyOfRange(hw6array,hw6check[0],hw6array.length)));
            System.out.println("Answer is: true");
        } else {
            System.out.println("Answer is: false");
        }

        System.out.println("\n" + "hw7: ");
        int hw7length=8;
        int n = 13;
        int[] hw7array = hw7create(hw7length);
        System.out.println("Original array: \t" + Arrays.toString(hw7array));
        int[] hw7moved = hw7moved(hw7array, n);
        System.out.println("Moved on " + n + " array: \t" + Arrays.toString(hw7moved));
    }
}

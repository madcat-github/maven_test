package mashibing.arithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 * 循环找到最小的,和循环开始的替换位置,从而得到升序的结果
 * 时间复杂度n ^ 2 (因为有2层嵌套的循环,近似于n^2)
 */
public class Selection {
    public static int[] sort(int[] arrayInput) {
        int[] array = Arrays.copyOf(arrayInput, arrayInput.length);
        for (int out = 0; out < array.length; out++) {
            int min = array[out];
            for (int inside = out + 1; inside < array.length; inside++) {
                if (array[inside] < min) {
                    min = array[inside];
                    MSBSort.swap(array, out, inside);

                }
            }
        }
        return array;
    }

    /**
     * 改进版的选择排序
     * 一次循环不仅找到最小值,还找到最大值
     *
     * @param array
     * @return
     */
    public static int[] sort_improve(int[] arrayInput) {
        int[] array = Arrays.copyOf(arrayInput, arrayInput.length);

        for (int out = 0; out < (array.length + 1) / 2; out++) {
            int minIndex = out;
            int maxIndex = array.length - 1 - out;

            if (array[maxIndex] < array[minIndex]) {
                int tempIndex = maxIndex;
                maxIndex = minIndex;
                minIndex = tempIndex;
            }

            for (int inside = out + 1; inside < array.length - 1 - out; inside++) {
                if (array[inside] < array[minIndex]) {
                    minIndex = inside;
                }
                if (array[inside] > array[maxIndex]) {
                    maxIndex = inside;
                }
            }

            MSBSort.swap(array, minIndex, out);
            MSBSort.swap(array, maxIndex, array.length - 1 - out);

//            System.out.println(Arrays.toString(array) + "[" + out + "] (" + minIndex + "," + maxIndex + ")");
        }

        return array;
    }


    public static void dataChecker(int times, int length) {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < times; i++) {
            int[] arr = new int[length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(100);
            }

            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            int[] arrSelf = sort_improve(arrCopy);
            Arrays.sort(arr);

            boolean same = true;
            for (int check = 0; check < arr.length; check++) {
                if (arr[check] != arrSelf[check]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                count++;
                System.out.println("[old]" + Arrays.toString(arrCopy) + ",排序后:" + Arrays.toString(arrSelf));
            }
        }
        System.out.println(count + "/" + times);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 5, -3, 777, 2, 9, 2548, 0, 22, 0, -33};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(sort(arr)));
//        System.out.println(Arrays.toString(sort_improve(arr)));
        dataChecker(1000, 15);
    }
}

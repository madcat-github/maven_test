package mashibing.arithmetic;

import java.util.Arrays;

/**
 * 插入排序
 * 从第二个开始.
 * 每一个和前面的比较,直到放入合适的位置
 *
 * @author madcat
 */
public class Insertion {

    public static void sort(int[] array) {
        for (int out = 1; out < array.length; out++) {
            for (int inside = out; inside > 0; inside--) {
                if (array[inside] < array[inside - 1]) {
                    MSBSort.swap(array, inside, inside - 1);//此处通过赋值可以不使用swap
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void sort_improve(int[] array) {
        for (int out = 1; out < array.length; out++) {
            for (int inside = out; inside > 0; inside--) {
                if (array[inside] < array[inside - 1]) {
                    int tempValue = array[inside];
                    array[inside] = array[inside - 1];
                    array[inside - 1] = tempValue;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        sort(new int[]{1, 3, 22, -9, 0, 28, -444, 3, 22, 324, 456, 1, 23, 76, 32, 4, 345, 34, 21, 13, 1, 23, 123, 1232});
//        sort_improve(new int[]{1, 2, 5, 7, 0, 99, -33});
    }
}

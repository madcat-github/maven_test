package mashibing.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序
 * 循环一遍选择最大的数,放到最后
 * 下次循环length - 2.将第二大的数放到倒数第二.
 * 以此类推,完成排序
 * <p>
 * 时间复杂度为O(n ^ 2)
 * <p>
 * 优化算法
 * <p>
 * 记录当前子循环是否有交换发生,如果没有,则说明排序完成
 * 从而达到最优时的时间复杂度为O(n)
 */
public class Bubble {

    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("-----------------------------------");
        for (int i = array.length; i > 0; i--) {
            for (int index = 0; index < i; index++) {
                if (index != array.length - 1 && array[index] > array[index + 1]) {
                    MSBSort.swap(array, index, index + 1);
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 优化的算法,时间复杂度降低到O(n)
     * 标记是否有交换,没有交换,直接结束程序
     *
     * @param array
     */
    public static void sort_improve(int[] array) {
        out:
        for (int out = array.length - 1; out >= 0; out--) {
            boolean swaped = false;
            for (int inside = 0; inside < array.length; inside++) {
                if (inside != array.length - 1 && array[inside] > array[inside + 1]) {
                    MSBSort.swap(array, inside, inside + 1);
                    swaped = true;
                }

            }
            if (!swaped) {
                System.out.println("stoped at " + (array.length - out));
                break out;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
//        sort(new int[]{1, 3, 2, 55, -33, -3, 330, 9});
        sort_improve(new int[]{1, 3, 2, 55, -33, -3, 330, 9});
        sort_improve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
    }
}

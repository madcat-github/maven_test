package mashibing.arithmetic;

import java.util.Arrays;

/**
 * 希尔排序
 * 优化后的 插入排序
 * <p>
 * 间隔大的时候移动次数少
 * 间隔小的时候移动距离短
 * 间隔X X-1 X-2 ...1 分别排序
 */
public class Shell {

    static int count = 0;

    public static int[] sort(int[] arrayInput) {
        int[] array = Arrays.copyOf(arrayInput, arrayInput.length);
        int h = 1;
        while (h <= array.length / 3) {
            h = 3 * h + 1;
        }
        System.out.println("h=" + h);
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            sort(array, gap);
        }
        return array;
    }

    public static void sort(int[] array, int step) {
        for (int loop = step; loop >= 0; loop--) {
            for (int i = step; i < array.length; i++) {//TODO i++ i+=sep ?
                for (int j = i; j >= 0; j -= step) {
                    if (j - step >= 0 && array[j] < array[j - step]) {
                        MSBSort.swap(array, j, j - step);
                        count++;
                    }
                }
            }
        }
        System.out.println("[" + step + "]" + Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 22, -9, 0, 28, -444, 3, 22, 324, 456, 1, 23, 76, 32, 4, 345, 34, 21, 13, 1, 23, 123, 1232};
        int[] arr2 = sort(arr);
        System.out.println(count);
        Arrays.sort(arr);
        System.out.println(arr.length);
        System.out.println(MSBSort.same(arr, arr2));
    }
}

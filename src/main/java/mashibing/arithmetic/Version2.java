package mashibing.arithmetic;

import java.util.Arrays;
import java.util.Random;

public class Version2 {
    public static void main(String[] args) {
        //准备数据
        int[] arr = newArr(15);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("原素组："+Arrays.toString(arr));
        int centerProsition = 0;
        if (arr.length % 2 == 0) {
            centerProsition = arr.length / 2;
        } else {
            centerProsition = arr.length / 2 + 1;
        }
        for (int i = 0; i < centerProsition; i++) {

            int minPosition = i;
            int maxPosition = arr.length-1 - i;
            if (arr[minPosition] > arr[maxPosition]) {
                int temp = minPosition;
                minPosition = maxPosition;
                maxPosition = temp;
            }
            for (int j = i + 1; j < arr.length -1- i; j++) {
                if (arr[j] > arr[maxPosition]) {
                    maxPosition = j;
                }
                if (arr[j] < arr[minPosition]) {
                    minPosition = j;
                }
            }

            swap(arr, i, minPosition);
            if (i != maxPosition) {
                //如果最大值不在i上直接交换
                swap(arr, arr.length - 1 - i, maxPosition);
            }else {
                //如果最大值在i上，经过上面最少值交换，已将最大值交换到minPosition，所以最大值交换要和maxPosition
                swap(arr, arr.length - 1 - i, minPosition);
            }
//            swap(arr, arr.length - 1 - i, maxPosition);
        }
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        boolean flag = validate(arr, arr1);
        System.out.println(flag);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean validate(int[] arr, int[] arr1) {
        boolean flag = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr[i] != arr1[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int[] newArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            int nextInt = r.nextInt(1000);
            arr[i] = nextInt;
        }
        return arr;
    }
}

package mashibing.arithmetic;

/**
 * 排序算法
 */
public class MSBSort {

    /**
     * 十种排序算法
     * 选择	selection			n^2	    		不稳
     * 冒泡	bubble			    n^2		    	稳
     * 插入	insertion			n^2			    稳
     * 堆	heap		    	n log 2 n		不稳
     * 希尔	shell			    n^1.3			不稳
     * 归并	merge			    n log 2 n		稳
     * 快速	quick   			n log 2 n		不稳
     * 桶	bucket	    		n+k			    稳
     * 计数	counting			n+k			    稳
     * 基数	radix		    	n+k			    稳
     */


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean same(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

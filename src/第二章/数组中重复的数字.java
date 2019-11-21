package 第二章;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 数组中重复的数字 {
    //方法一：排序后遍历数组
    //方法二：哈希表
    //方法三：重排数组，只适用于数字在0~n-1范围内的数组
    public static HashSet<Integer> duplicate(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        if (a == null || a.length < 0) return null;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > a.length - 1) return null;
        }
        for (int i = 0; i < a.length; i++) {
            while (a[i]!=i) {
                if (a[i] == a[a[i]]) {
                    set.add(a[i]);
                    break;
                }
                else {
                    int temp = a[i];
                    a[a[i]] = a[i];
                    a[i] = temp;
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,0,2,5,3};
        HashSet<Integer> duplicate = duplicate(a);
        System.out.println(duplicate);
        int[] b = new int[]{0,1,2,3,4,5,6,7};
        System.out.println(duplicate(b));
    }
}

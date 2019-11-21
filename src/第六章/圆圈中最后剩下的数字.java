package 第六章;

import java.util.Iterator;
import java.util.LinkedList;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int m = 3;
        int res = theLastNum(list,m);
        System.out.println(res);
    }

    private static Integer theLastNum(LinkedList<Integer> list, int m) {
        if (list == null || list.size()<=0) return null;
        int count = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext() && list.size()>1){
            count++;
            iterator.next();
            if (count == m) { iterator.remove(); count = 0;}
            if (!iterator.hasNext()) iterator = list.iterator();
        }
        return list.get(0);
    }
}

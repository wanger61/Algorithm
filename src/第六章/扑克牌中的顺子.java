package 第六章;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        ArrayList<Integer> pokes = new ArrayList<>();
        pokes.add(0);
        pokes.add(0);
        for (int i=2;i<=13; i++){
            pokes.add(i);
            pokes.add(i);
            pokes.add(i);
            pokes.add(i);
        }
        int[] pokesInHand = new int[5];
//        for (int i=0; i<5 ; i++){
//            pokesInHand[i] = pokes.remove((int)(Math.random()*pokes.size()));
//            System.out.println(pokesInHand[i]);
//        }
        //boolean res = isContinous(pokesInHand);
        boolean res = isContinous(new int[]{2,5,3,4,7});
        System.out.println(res);
    }

    private static boolean isContinous(int[] pokesInHand) {
        if (pokesInHand == null || pokesInHand.length<=4) return false;
        Arrays.sort(pokesInHand);
        int zeroCount = 0;
        int gapCount = 0;
        for (int i=0; i<=1; i++){
            if (pokesInHand[i] == 0) zeroCount++;
        }
        for (int i=zeroCount; i<=3; i++){
            if (pokesInHand[i] >= pokesInHand[i+1]) return false;
            else{
                if (pokesInHand[i+1] - pokesInHand[i] >1) gapCount += pokesInHand[i+1] - pokesInHand[i]-1;
            }
        }
        if (gapCount==0 || gapCount == zeroCount) return true;
        else return false;
    }
}

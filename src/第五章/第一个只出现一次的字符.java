package 第五章;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        String str = "abaccdeff";
        char res = findOnlyOneChar(str);
        System.out.print(res);
    }

    private static Character findOnlyOneChar(String str) {
        if (str == null) throw new RuntimeException("Invalid input");
        char[] chars = str.toCharArray();
        if (chars.length <= 0) return null;
        int[] hashtable = new int[256];
        for (int i=0; i<chars.length; i++){
            hashtable[chars[i]]++;
        }
        for (int i=0; i<chars.length; i++){
            if (hashtable[chars[i]] == 1) return chars[i];
        }
        return null;
    }

//    private static Character findOnlyOneChar(String str) {
//        if (str == null) throw new RuntimeException("Invalid input");
//        char[] chars = str.toCharArray();
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (int i=0; i<chars.length; i++){
//            Integer times = map.get(chars[i]);
//            if (times == null){
//                map.put(chars[i],1);
//            }else {
//                map.put(chars[i],++times);
//            }
//        }
//        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Character, Integer> next = iterator.next();
//            if (next.getValue() == 1) return next.getKey();
//        }
//        return null;
//    }
}

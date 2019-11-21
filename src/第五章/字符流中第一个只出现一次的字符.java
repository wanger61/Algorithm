package 第五章;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 字符流中第一个只出现一次的字符 {
    public static void main(String[] args) {
        String str = "ggbbcc";
        char res = findFirstOnlyOneChar(str);
        System.out.print(res);
    }

    private static Character findFirstOnlyOneChar(String str) {
        if (str == null) return null;
        char[] chars = str.toCharArray();
        if (chars.length <= 0) return null;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0 ; i<chars.length; i++){
            if (map.get(chars[i]) == null){
                map.put(chars[i],i);
            }else {
                map.put(chars[i],-1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> s : entries){
            if (s.getValue()!=-1){
                if (s.getValue()<minIndex){ minIndex = s.getValue();}
            }
        }
        if (minIndex == Integer.MAX_VALUE) return null;
        return chars[minIndex];
    }
}

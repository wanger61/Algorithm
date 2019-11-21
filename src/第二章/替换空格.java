package 第二章;

public class 替换空格 {
    public static void replaceBlank(char[] string, int length){ //length为字符数组最大容量
        if (string==null||length<=0) return;
        int oldLength = 0;
        int Blank = 0;
        int i = 0;
        while (string[i]!='\0') {
            oldLength++;
            if (string[i] == ' ') Blank++;
            i++;
        }
        int newLength = oldLength + 2*Blank;
        if (newLength>length) return; //超过容量
        while (oldLength<newLength && oldLength>=0){
            if (string[oldLength]==' '){
                string[newLength--] = '0';
                string[newLength--] = '2';
                string[newLength--] = '%';
            }else {
            string[newLength--] = string[oldLength];
            }
            oldLength--;
        }
    }

    public static void main(String[] args) {
        char[] a = new char[50];
        a[0] = 'a';
        a[1] = ' ';
        a[2] = 'b';
        a[3] = '\0';
        replaceBlank(a,50);
        System.out.println(a);
    }
}

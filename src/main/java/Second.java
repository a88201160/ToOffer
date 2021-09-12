/**
 * 核心注意点为 indexOf 返回的是对应字符的 ASCII 码而不是数字
 * 注意不能转换成十进制数进行计算然后再转换回来这可能导致溢出
 * ERROR 我想的太复杂了，两个字符串不同长，短的不够不就是 0 嘛，直接算就行，两个链表相加也能这么考虑
 */
public class Second {

    public static String addBinary(String a, String b) {
        int left = a.length() - 1;
        int right = b.length() - 1;
        boolean needCarry = false;
        StringBuilder builder = new StringBuilder();
        while (left >= 0 || right >= 0) {
            int first = left >= 0 ? a.charAt(left--) - '0' : 0;
            int second = right >= 0 ? b.charAt(right--) - '0' : 0;
            int current = first + second + (needCarry ? 1 : 0);
            if (current > 1) {
                current -= 2;
                needCarry = true;
            }
            builder.insert(0, current);
        }
        if (needCarry) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "110"));
    }
}

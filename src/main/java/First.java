/**
 * 整数除法，不能借助与 * 、/、% 因此考虑使用 - ，还得考虑异常情况 -2^31 / -1 越界问题
 * 还得考虑正负号问题，两者中有个负数那么结果就是负的，计算时需要将数全部转换为负数计算，因为转换为正数可能会溢出
 * 还得考虑如何提高计算效率，因为 2^31 / 1 则性能十分低下，如果时间复杂度改善 O(n)
 */
public class First {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xC0000000 && dividend <= value + value) {
                value += value;
                quotient += quotient;
            }
            dividend -= value;
            result += quotient;
        }
        return negative == 1 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MAX_VALUE, 1));
    }
}

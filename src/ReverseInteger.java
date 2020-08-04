public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse(120));
    }

    public static int reverse(int x) {

//        if (x > 0){
//            String s = new StringBuilder(String.valueOf(x)).reverse().toString();
//            int i = 0;
//            try {
//                i = Integer.parseInt(s);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//
//            return i;
//        }else{
//
//            String s = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
//            int i = 0;
//            try {
//                i = Integer.parseInt(s);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//
//            return -i;
//        }
//
//    }

        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;

    }
}

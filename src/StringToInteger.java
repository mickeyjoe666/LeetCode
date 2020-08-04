public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE );
        System.out.println(Integer.MIN_VALUE );
        System.out.println(myAtoi("       +42"));
    }


//    public static int myAtoi(String str) {
//        char [] ch = str.toCharArray();
//        StringBuffer sb = new StringBuffer();
//        boolean minusCheck = false;
//
//        for(int i = 0; i < ch.length; i++){
//            if(ch[i] == ' '){
//                if (sb.equals("")){
//                    continue;
//                }
//            }else if(ch[i] == '-'){
//                minusCheck = true;
//                continue;
//            }else if(Character.isDigit(ch[i])){
//                sb.append(ch[i]);
//            }else{
//                if (sb.equals("")){
//                    continue;
//                }else{
//                    return 0;
//                }
//            }
//        }
//        int i;
//        try {
//            i = Integer.parseInt(new String(sb));
//            if(minusCheck){
//                return -i;
//            }else{
//                return i;
//            }
//        } catch (NumberFormatException e){
//            if(minusCheck){
//                return Integer.MIN_VALUE;
//            }else{
//                return Integer.MAX_VALUE;
//            }
//        }
//    }

    public static int myAtoi(String str) {
        int i=0,n=str.length();
        while(i<n&&str.charAt(i)==' ')i++;
        if(i==n)return 0;
        int flag=1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            if(str.charAt(i)=='-'){
                flag=-1;
            }
            i++;
        }
        int ans=0;
        while(i<n&&Character.isDigit(str.charAt(i))) {
            int temp=str.charAt(i)-'0';
            if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)))
                return Integer.MAX_VALUE ;
            //以正数为列，考虑稳大于和加temp才大于的情况
            if (flag == -1 && (ans > -(Integer.MIN_VALUE / 10) || (ans == -(Integer.MIN_VALUE / 10) && temp > 8)))
                return Integer.MIN_VALUE;
            ans=ans*10+temp;
            i++;
        }
        return ans*flag;
    }
}

import java.util.*;

public class FindTheWinnerOfAnArrayGame {

    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{3,2,1}, 10));
    }


    //使用LinkedList结构，实现简单的数组移位
    public static int getWinner(int[] arr, int k) {

        if( k >= arr.length){
            return Arrays.stream(arr).max().getAsInt();
        }else{
            int score = 0;

            LinkedList<Integer> list = new LinkedList<Integer>();//int[]不能直接转LinkedList因此需要手写
            for (int index = 0; index < arr.length; index++)
            {
                list.add(arr[index]);
            }
            while(true){

                if(list.get(0) > list.get(1)){
                    list.add(list.remove(1));
                }else{
                    score = 0;
                    list.add(list.remove(0));
                }
                score++;
                if(score == k){
                    return list.get(0);
                }
            }
        }

    }

}

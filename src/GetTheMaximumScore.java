import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class GetTheMaximumScore {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{4,6,9,13,19,27}, new int[]{4,8,12,19,23,26,29}));

    }

    public static int maxSum(int[] nums1, int[] nums2) {
        HashSet<Object> set1 = new HashSet<>();     //求交集需要使用HashSet类
        HashSet<Object> set2 = new HashSet<>();

        for (int index = 0; index < nums1.length; index++) {
                set1.add(nums1[index]);
            }
        for (int index = 0; index < nums2.length; index++) {
            set2.add(nums2[index]);
        }
        set1.retainAll(set2);                       //取两个数组的交集数量为n，根据n将数组划分为n+1个区间

        TreeSet myTreeSet = new TreeSet();        //set是无序的，因此必须要转化成treeset排序
        myTreeSet.addAll(set1);

        int i = 0;
        int j = 0;
        long result = 0;

        for(Object number : myTreeSet){
            long sum1 = 0;
            long sum2 = 0;
            while(nums1[i] != (int)number){
                sum1 += nums1[i];
                i++;
            }
            while(nums2[j] != (int)number){
                sum2 += nums2[j];
                j++;
            }
            result += Math.max(sum1, sum2);         //  求每个区间和的最大值并相加
            result = (int) (result % (Math.pow(10, 9) + 7));
        }

        long lastSum1 = 0;
        long lastSum2 = 0;

        while(i < nums1.length){
            lastSum1 += nums1[i];
            i++;
        }
        while(j < nums2.length){
            lastSum2 += nums2[j];
            j++;
        }
        result += Math.max(lastSum1, lastSum2);         //因为for无法遍历到最后一个区间，在最后需要加一次最后一段区间的值
        return (int) (result % (Math.pow(10, 9) + 7));

    }





}

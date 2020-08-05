import java.util.ArrayList;
import java.util.List;

public class HouseRobberThree {
    //动态规划
    /*首先需要判断每个点有两种状态：被打劫和不被打劫，通过设置一个点的状态可以知道它相邻所有点的状态
    然后遍历整个树，知道找出最后的叶子节点，通过对叶子节点设置两种状态，推断出每种状态下叶子节点的
    父节点不同状态下的值*/
    public int rob(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }


    static int[] dfs(TreeNode cur) {
        if(cur == null) {
            return new int[2];
        }
        int[] vLeft = new int[2];
        int[] vRight = new int[2];
        vLeft = dfs(cur.left);
        vRight = dfs(cur.right);

        int pattern1 = Math.max(vLeft[0], vLeft[1]) + Math.max(vRight[0], vRight[1]);
        int pattern2 = vLeft[0] + vRight[0] + cur.val;

        int[] result = new int[]{pattern1, pattern2};
        return result;
    }
}

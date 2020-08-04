import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {

        CourseSchedule schedule = new CourseSchedule();

        boolean result = schedule.canFinish(2, new int[][]{{1, 0}, {0, 1}});

        System.out.println(result);


    }

    List<List<Integer>> edges;
    int[] visited;
    boolean vaild = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        for(int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]); //初始化树
        }

        System.out.println(edges);

        for(int i = 0; i < numCourses && vaild; ++i) {     //注意for跳出的条件，一旦发现形成环就跳出并返回
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        return vaild;
    }


    public void dfs(int u) {    //深度优先搜索
        visited[u] = 1;
        for(int v : edges.get(u)) {
            if(visited[v] == 0) {
                dfs(v);
                if(!vaild){
                    return;
                }
            }else if (visited[v] == 1) {
                vaild = false;
                return;
            }
        }
        visited[u] = 2;
    }

}

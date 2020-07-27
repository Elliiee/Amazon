import java.util.*;

public class tt207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i= 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;

            if (graph.containsKey(prerequisites[i][1])){
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> curList = graph.get(cur);
            for (int i = 0; curList != null && i < curList.size(); i++){
                indegree[curList.get(i)]--;
                if (indegree[curList.get(i)] == 0){
                    queue.offer(curList.get(i));
                }
            }
        }
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] != 0)
                return false;
        }
        return true;
    }
}

import java.util.*;

class hambfpara {

    public static void hamiltonianCycle(int[][] graph) throws InterruptedException {
        int n = graph.length;
        Integer[] temp = new Integer[n-1];
        for (int i=0; i < n-1; i++) {
            temp[i] = i+1;
        }
        List<List<Integer>> permutations = permute(Arrays.asList(temp));
        permutations.parallelStream().forEach(per -> verify(per,graph));
    }

    public static void verify(List<Integer> path, int[][] graph){
        if(graph[path.get(path.size()-1)][0]!=1)
            return;
        for (int v=0;v<path.size();v++) {
            if (v==0){
                if(graph[0][path.get(v)]!=1)
                    return;
            }
            else{
                if(graph[path.get(v)][path.get(v-1)]!=1)
                    return;
            }
        }
        System.out.println(java.util.Arrays.toString(path.toArray()));

    }


    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> nums) {
        if (tempList.size() == nums.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (tempList.contains(nums.get(i))) {
                    continue;
                }
                tempList.add(nums.get(i));
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }}}



    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        int[][] graph4 ={
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1},
                {1,0,1,0}
        };
        int[][] graph6 ={
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,1,0,1},
                {1,0,1,0,1,0}
        };
        int[][] graph8 ={
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
        };

        int[][] graph10 = {
                {0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,0}
        };

        try {
            hamiltonianCycle(graph10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;

        System.out.println("Program runtime: " + runtime + " milliseconds.");

    }
}

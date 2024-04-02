import java.util.*;

class HamBrute {


    /*La méthode hamiltonianCycle prend un graphe en entrée et tente
     de trouver tous les cycles hamiltoniens possibles dans le graphe
      à l'aide d'un algorithme de force brute. Elle utilise la méthode
      permute pour générer toutes les permutations possibles des sommets,
       puis appelle la méthode verify sur chaque permutation pour
       vérifier s'il s'agit d'un cycle hamiltonien.*/
    public static void hamiltonianCycle(int[][] graph) {
        int n = graph.length;
        Integer[] temp = new Integer[n-1];
        for (int i=0; i < n-1; i++) {
            temp[i] = i+1;
        }
        List<List<Integer>> permutations = permute(Arrays.asList(temp));

        for (List<Integer> per : permutations) {
            verify(per,graph);

        }

    }
    /*La méthode verify prend en entrée un chemin (c'est-à-dire une liste de sommets)
     et un graphe, et vérifie si le chemin est un cycle hamiltonien dans le graphe.
      Elle ne renvoie rien mais imprime le chemin s'il s'agit d'un cycle hamiltonien.
       parametre chemin une liste de sommets représentant un chemin et paraetrem
       graphe un tableau 2D représentant la matrice d'adjacence du graphe*/
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

        System.out.print("0 ");

        for (int el : path) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    /*La méthode permute prend une liste d'entiers en entrée
    et génère toutes les permutations possibles des entiers en
     utilisant l'algorithme backtracking.nums une liste d'entiers à
     permuter elle renvoie une liste de listes d'entiers représentant
      toutes les permutations possibles de la liste d'entrée.*/
    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    /*La méthode backtrack est une méthode d'aide pour la méthode
    permute qui met en œuvre l'algorithme de backtracking pour
    générer des permutations.*/
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
        hamiltonianCycle(graph10);
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;

        System.out.println("Program runtime: " + runtime + " milliseconds.");
    }
}

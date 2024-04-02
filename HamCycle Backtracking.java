import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycleBT {
    private int[][] graph;
    //un tableau 2D représentant le graphique d'entrée.
    private int[] path;
    //est un tableau qui contiendra le chemin actuel exploré par l'algorithme.
    private boolean[] visited;
    //est un tableau qui indique quels sommets ont été visités jusqu'à présent
    private List<int[]> cycles;
    //est une liste qui contiendra tous les cycles hamiltoniens trouvés dans le graphe.



    // Contructeur de la classe
    public HamiltonianCycleBT(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        this.graph = graph;
        this.path = new int[n];
        this.visited = new boolean[n];
        this.cycles = new ArrayList<>();
    }

    //une méthode d'aide qui vérifie si un sommet v peut être ajouté à la pos-ième position
    // du chemin actuel sans violer la condition du cycle hamiltonien.
    private boolean isSafe(int pos, int v) {
        if (graph[path[pos-1]][v]!=1){
            return false;
        }
        if (visited[v]) {
            return false;
        }
        return true;
    }

    /*La fonction récursive principale qui explore tous les
    chemins possibles à partir de la position courante pos dans
    le tableau des chemins. Lorsqu'elle atteint la dernière
    position du tableau de chemins, elle vérifie si le dernier
    et le premier sommet sont adjacents et, si c'est le cas,
    ajoute le chemin actuel à la liste des cycles hamiltoniens.*/
    private void HamiltonianCyclesUtil(int pos) {
        int n = graph.length;
        if (pos == n) {
            // check if the last and first vertices are adjacent
            if (graph[path[pos-1]][path[0]]==1) {
                cycles.add(path.clone());
            }
            return;
        }

        for (int v = 1; v < n; v++) {
            if (isSafe(pos, v)) {
                path[pos] = v;
                visited[v] = true;
                HamiltonianCyclesUtil(pos + 1);
                visited[v] = false;
            }
        }
    }

    /*une méthode qui lance la recherche de cycles hamiltoniens en appelant
    HamiltonianCyclesUtil avec une position initiale de 1, en supposant
     que le sommet 0 est le sommet de départ, et qui imprime les solutions.*/
    public void Solve(){
        path[0] = 0;
        visited[0] = true;
        HamiltonianCyclesUtil(1);

        for (int[] cycle : cycles) {
            for (int v : cycle) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

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
        HamiltonianCycleBT finder = new HamiltonianCycleBT(graph10);
        finder.Solve();
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;

        System.out.println("Program runtime: " + runtime + " milliseconds.");

    }

}


import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDiGraph {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int ver = sc.nextInt();

        System.out.println("Enter Adjacency Matrix");
        int[][] adjMat = new int[ver][ver];

       for(int i=0; i<ver; i++){
            for(int j=0; j<ver; j++){
                adjMat[i][j] = sc.nextInt();
            }
       }

       System.out.println("Enter the start vertex");
       int sVer = sc.nextInt();

       System.out.println("BFS traversal from the vertex "+ sVer + " :");
       bfs(adjMat, sVer, ver);


        sc.close();
    }

    private static void bfs(int[][] adjMat, int sVer, int ver){
        boolean[] visited = new boolean[ver];
        Queue<Integer> queue = new LinkedList<>();

        visited[sVer]=true;
        queue.add(sVer);

        while(!queue.isEmpty()){
            int curVer = queue.poll();
            System.out.print(curVer+" ");

            for(int i =0; i<ver; i++){
                if(!visited[i]){
                    visited[i]= true;
                    queue.add(i);
                }
            }
        }

    }
    
}

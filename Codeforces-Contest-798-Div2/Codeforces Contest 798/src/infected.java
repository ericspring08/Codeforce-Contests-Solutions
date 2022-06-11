import java.util.*;
import java.io.*;

public class infected {
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0;t<T;t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i = 0;i<N;i++) {
                graph.add(new ArrayList<Integer>());
            }

            for(int i = 0;i<N-1;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                graph.get(a).add(b);
                graph.get(b).add(a);
            }


        }
    }

    public static void dfs() {

    }
}

import java.util.*;
import java.io.*;

public class infected {
    static ArrayList<ArrayList<Integer>> graph;
    static int ans = 0;
    static int num_of_children = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

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
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;

                graph.get(u).add(v);
            }
            ans = 0;
            dfs(0);
            pw.println(ans);
        }
        pw.close();
    }

    public static void dfs(int node) {
        if(graph.get(node).size() == 2) {
            int left_sum = getChildren(graph.get(node).get(0));
            int right_sum = getChildren(graph.get(node).get(1));

            if(left_sum > right_sum) {
                ans += left_sum;
                dfs(graph.get(node).get(1));
            } else {
                ans += right_sum;
                dfs(graph.get(node).get(0));
            }
        } else if(graph.get(node).size() == 1) {
            ans += getChildren(graph.get(node).get(0));
        }
    }

    public static int getChildren(int node) {
        if(graph.get(node).size() == 2) {
            return 2 + getChildren(graph.get(node).get(0)) + getChildren(graph.get(node).get(1));
        } else if(graph.get(node).size() == 1) {
            return 1 + getChildren(graph.get(node).get(0));
        } else {
            return 0;
        }
    }
}

import java.util.*;
import java.io.*;

public class perm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] n = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i<N;i++) {
                n[i] = Integer.parseInt(st.nextToken());
            }

            if(N == 1) {
                pw.println(-1);
                continue;
            }

            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> _final = new ArrayList<>();
            
            for(int i = 1;i<=N;i++) {
                a.add(i);
            }

            for(int i = 0;i<N;i++) {
                if(a.size() >= 2 && a.get(0) == n[i]) {
                    _final.add(a.get(1));
                    a.remove(1);
                } else {
                    _final.add(a.get(0));
                    a.remove(0);
                }
            }
            
            if(_final.get(N - 1) == n[N-1]) {
                int temp = _final.get(N -1);
                _final.set(N - 1, _final.get(N - 2));
                _final.set(N - 2, temp);
            }

            for(int i = 0;i<N;i++) {
                pw.print(_final.get(i) + " ");
            }
            pw.println();
        }
        pw.close();
    }
}

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class lex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String[] n = br.readLine().split("");
            String[] m = br.readLine().split("");

            // sort arrays
            Arrays.sort(n);
            Arrays.sort(m);

            // two pointers algorithm
            int p1 = 0;
            int p2 = 0;
            int k1 = 0;
            int k2 = 0;

            String c = "";

            while(p1 < N && p2 < M) {
                if(n[p1].compareTo(m[p2]) <= 0) {
                    k2 = 0;
                    if(k1 == K) {
                        k1 = 0;
                        c += m[p2];
                        p2++;
                        k2++;
                    } else {
                        c += n[p1];
                        p1++;
                        k1++;
                    }
                } else {
                    k1 = 0;
                    if(k2 == K) {
                        k2 = 0;
                        c += n[p1];
                        p1++;
                        k1++;
                    } else {
                        c += m[p2];
                        p2++;
                        k2++;
                    }
                }
            }
            System.out.println(c);
        }
    }
}
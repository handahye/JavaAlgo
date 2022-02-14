import java.io.*;
import java.util.*;

public class BOJ_21919 {
    public static boolean[] prime = new boolean[1000001];
    public static boolean[] visit = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        chkPrime();
        prime[0] = prime[1] = true;
        st = new StringTokenizer(br.readLine().trim());
        long result = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!prime[num] && !visit[num]) {
                visit[num] = true;
                result *= num;
            }
        }
        if (result == 1)
            System.out.println("-1");
        else
            System.out.println(result);
    }

    public static void chkPrime() {
        for (int i = 2; i <= 1000000; i++) {
            for (int j = i * 2; j <= 1000000; j += i) {
                prime[j] = true;
            }
        }
    }
}

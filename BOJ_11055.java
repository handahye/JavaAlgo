import java.io.*;
import java.util.*;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }

            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);

    }
}

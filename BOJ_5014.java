import java.io.*;
import java.util.*;

public class BOJ_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int F = Integer.parseInt(st.nextToken()); // F층 건물
        int S = Integer.parseInt(st.nextToken()); // 강호 위치
        int G = Integer.parseInt(st.nextToken()); // 스타트 링크 있는 층
        int U = Integer.parseInt(st.nextToken()); // 위로 U만큼
        int D = Integer.parseInt(st.nextToken()); // 아래로 D만큼
        int res = 0;
        boolean success = false;
        boolean[] visit = new boolean[F + 1];
        boolean dir = true; // true면 위, false면 아래
        while (true) {
            if (S < G) {
                if (S + U <= F) {
                    dir = true;
                } else if (S - D > 0) {
                    dir = false;
                } else {
                    success = false;
                    break;
                }
            } else if (S > G) {
                if (S - D > 0) {
                    dir = false;
                } else if (S + U <= F) {
                    dir = true;
                } else {
                    success = false;
                    break;
                }
            } else if (S == G) {
                success = true;
                break;
            }

            if (dir) {
                if (!visit[S + U]) {
                    visit[S + U] = true;
                    S += U;
                    res++;
                } else {
                    success = false;
                    break;
                }
            } else {
                if (!dir) {
                    if (!visit[S - D]) {
                        visit[S - D] = true;
                        S -= D;
                        res++;
                    } else {
                        success = false;
                        break;
                    }
                }
            }

        }
        if (!success)
            System.out.println("use the stairs");
        else
            System.out.println(res);
    }
}

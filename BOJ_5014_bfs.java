import java.io.*;
import java.util.*;

public class BOJ_5014_bfs {
    static int F, S, G;
    static int[] move;
    static int[] dir = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        F = Integer.parseInt(st.nextToken()); // F층 건물
        S = Integer.parseInt(st.nextToken()); // 강호 위치
        G = Integer.parseInt(st.nextToken()); // 스타트 링크 있는 층
        dir[0] = Integer.parseInt(st.nextToken()); // 위로 U만큼
        dir[1] = -Integer.parseInt(st.nextToken()); // 아래로 D만큼
        move = new int[F + 1];
        bfs(S);

    }

    static void bfs(int cur) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[F + 1];

        que.add(cur);
        visit[cur] = true;
        move[cur] = 0;

        while (!que.isEmpty()) {
            int pos = que.poll();
            if (pos == G) {
                System.out.println(move[pos]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = pos + dir[i];
                if (next > F || next < 1)
                    continue;
                if (!visit[next]) {
                    visit[next] = true;
                    que.add(next);
                    move[next] = move[pos] + 1;
                }
            }
        }
        System.out.println("use the stairs");

    }
}

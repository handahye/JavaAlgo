import java.io.*;
import java.util.*;

public class BOJ_10711_메모리초과 {
    public static int H, W;
    public static int[][] map, tmp;
    public static Queue<Node> que = new LinkedList<Node>();
    public static int[] dx = { 0, 0, 0, 1, 1, 1, -1, -1, -1 };
    public static int[] dy = { 0, 1, -1, 0, 1, -1, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H + 1][W + 1];
        tmp = new int[H + 1][W + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String str = st.nextToken();
            for (int j = 0; j < W; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = str.charAt(j) - '0';
                    que.add(new Node(i, j));
                }
            }
        }

        copyArray(map, tmp);
        int res = 0;
        while (true) {
            int qsize = que.size();
            for (int i = 0; i < qsize; i++) {
                int x = que.peek().x;
                int y = que.peek().y;
                que.poll();
                int cnt = 0;
                for (int d = 0; d < 9; d++) {
                    int xx = x + dx[d];
                    int yy = y + dy[d];
                    if (xx >= H || yy >= W || x < 0 || y < 0) {
                        continue;
                    }
                    if (map[xx][yy] == -1) {
                        cnt++;
                    }
                }
                if (cnt >= map[x][y]) {
                    tmp[x][y] = -1;
                } else {
                    que.add(new Node(x, y));
                }
            }
            if (que.size() == qsize || que.size() == 0) {
                break;
            }
            copyArray(tmp, map);
            res++;
        }

        System.out.println(res);

    }

    public static void copyArray(int[][] a, int[][] b) {
        for (int i = 0; i < H; i++) {
            System.arraycopy(a[i], 0, b[i], 0, W);
        }
    }

    public static class Node {
        public int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

import java.util.*;

public class BOJ_10711 {

    static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
    static int[] dy = { -1, 1, -1, 0, 1, -1, 0, 1 };
    static int h, w;
    static char[][] board;
    static Queue<int[]> no_sand;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        h = scan.nextInt();
        w = scan.nextInt();

        board = new char[h][w];
        no_sand = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            String str = scan.next();
            for (int j = 0; j < w; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == '.')
                    no_sand.add(new int[] { i, j });
            }
        }

        int count = 0;
        while (!no_sand.isEmpty()) {
            int size = no_sand.size();

            for (int i = 0; i < size; i++) {
                int[] current = no_sand.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                        if (board[nx][ny] != '.') {
                            board[nx][ny]--;
                            if (board[nx][ny] == '0') {
                                board[nx][ny] = '.';
                                no_sand.add(new int[] { nx, ny });
                            }
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(count - 1);
        scan.close();
    }
}

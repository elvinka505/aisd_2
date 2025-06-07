import java.io.*;
import java.util.*;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] moves = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            moves[i] = new int[k];
            for (int j = 0; j < k; j++) {
                moves[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] win = new boolean[n + 1];
        win[0] = false;

        for (int i = 1; i <= n; i++) {
            boolean canWin = false;
            for (int move : moves[i]) {
                if (i - move >= 0 && !win[i - move]) {
                    canWin = true;
                    break;
                }
            }
            win[i] = canWin;
        }

        System.out.println(win[n] ? "First" : "Second");
    }
}
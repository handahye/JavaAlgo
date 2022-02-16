import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };
        Integer lotto[] = Arrays.stream(lottos).boxed().toArray(Integer[]::new);
        Arrays.sort(lotto, Collections.reverseOrder());
        int[] tmp = { 6, 6, 5, 4, 3, 2, 1 };
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < win_nums.length; i++) {
            set.add(win_nums[i]);
        }

        int low = 0;
        int high = 0;
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] == 0) {
                high++;
            }
            if (set.contains(lotto[i])) {
                low++;
                high++;
            }
        }

        System.out.println(cnt);
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
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
        answer[0] = tmp[high];
        answer[1] = tmp[low];
        return answer;
    }
}
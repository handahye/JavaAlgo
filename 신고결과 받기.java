import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            res.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            String[] user = report[i].split(" ");
            if (map.containsKey(user[1]) == false) {
                List<String> list = new ArrayList<>();
                list.add(user[0]);
                map.put(user[1], list);
            } else {
                if (!map.get(user[1]).contains(user[0])) {
                    map.get(user[1]).add(user[0]);
                }

            }
        }
        for (String key : map.keySet()) {
            int size = map.get(key).size(); // 신고한 사람 수
            if (size >= k) {
                for (String usr : map.get(key)) { // 신고한 사람 이름
                    int idx = res.get(usr); // 신고한 사람 인덱스
                    answer[idx]++;
                }

            }
        }
        return answer;
    }
}
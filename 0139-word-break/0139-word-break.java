import java.util.*;

class Solution {

    Map<String, Integer> mp = new HashMap<>();

    int fun(int i, String s, Map<String, Integer> m1, String temp) {

        if (i >= s.length()) {
            System.out.println(temp);

            if (temp.length() == 0)
                return 1;

            return 0;
        }

        String key = Integer.toString(i) + "+" + temp;

        if (mp.containsKey(key))
            return mp.get(key);

        int m = 0;

        temp += s.charAt(i);

        if (m1.containsKey(temp)) {
            int a = fun(i + 1, s, m1, "");
            m = m | a;
        }

        int a = fun(i + 1, s, m1, temp);
        m = m | a;

        mp.put(key, m);

        return m;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Integer> m1 = new HashMap<>();

        for (String a : wordDict) {
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        mp.clear();

        return fun(0, s, m1, "") == 1;
    }
}
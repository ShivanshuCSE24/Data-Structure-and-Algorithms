class Solution {

    int INF = 1000000000;

    boolean check(int l, int r, String s) {

        if (s.charAt(l) == '0')
            return false;

        StringBuilder tmp = new StringBuilder();

        for (int i = l; i <= r; i++) {
            tmp.append(s.charAt(i));
        }

        tmp.reverse();

        int i = 0;
        int num = 0;

        for (int j = 0; j < tmp.length(); j++) {

            char a = tmp.charAt(j);

            if (a == '0') {
                i++;
                continue;
            }

            num = num + (int)Math.pow(2, i);
            i++;
        }

        for (int j = 0; j <= 10; j++) {

            int kk = (int)Math.pow(5, j);

            if (num == kk)
                return true;
        }

        return false;
    }


    int fun(int p, int i, String s) {

        if (i == s.length() - 1) {

            if (check(p, i, s))
                return 0;

            return INF;
        }

        int m = INF;

 
        if (check(p, i, s)) {

            int a = 1 + fun(i + 1, i + 1, s);

            m = Math.min(m, a);
        }

        int a = fun(p, i + 1, s);

        m = Math.min(m, a);

        return m;
    }


    public int minimumBeautifulSubstrings(String s) {

        int ans = fun(0, 0, s);

        return ans == INF ? -1 : ans + 1;
    }
}
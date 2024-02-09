
import java.util.ArrayList;
import java.util.HashMap;

public class  Optimized {
    static int[] a = new int[6];
    static int[] b = new int[6];
    static ArrayList<int[]> c = new ArrayList<>();
    static ArrayList<int[]> d = new ArrayList<>();
    static int[] s = {1, 2, 3, 4, 5, 6};
    static HashMap<Integer, Integer> st = new HashMap<>();

    public static void main(String[] args) {
        for (int i : s) {
            for (int j : s) {
                st.put(i + j, st.getOrDefault(i + j, 0) + 1);
            }
        }
        backtrack(0);
        for (int[] arr : c) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int[] arr : d) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean rule(int[] a, int[] b) {
        HashMap<Integer, Integer> t = new HashMap<>();
        for (int i : a) {
            for (int j : b) {
                if (i != 0 && j != 0) {
                    t.put(i + j, t.getOrDefault(i + j, 0) + 1);
                }
            }
        }
        for (int key : t.keySet()) {
            if (t.get(key) > st.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

    static boolean backtrack(int cur) {
        if (cur == 6) {
            c.add(a.clone());
            d.add(b.clone());
            return true;
        } else {
            for (int i = 1; i <= 4; i++) {
                a[cur] = i;
                for (int j = 1; j <= 8; j++) {
                    b[cur] = j;
                    if (rule(a, b)) {
                        if (backtrack(cur + 1)) {
                            return true;
                        }
                    }
                    b[cur] = 0;
                }
                a[cur] = 0;
            }
        }
        return false;
    }
}

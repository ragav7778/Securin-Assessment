import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  Bruteforce {

    // Function to verify the probability of the newly risingclear spots of the dices
    public static boolean isPossible(ArrayList<Integer> temp, ArrayList<Integer> temp2, Map<Integer, Integer> mp) {
        Map<Integer, Integer> mpCheck = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mpCheck.put(temp.get(i) + temp2.get(j), mpCheck.getOrDefault(temp.get(i) + temp2.get(j), 0) + 1);
            }
        }

        return mp.equals(mpCheck);
    }

    // Function to generate all the combinations
    public static void makeCombination(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tmp, ArrayList<Integer> elements, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < elements.size(); i++) {
            tmp.add(elements.get(i));
            makeCombination(ans, tmp, elements, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> makeComb(ArrayList<Integer> elements, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        makeCombination(ans, tmp, elements, k);
        return ans;
    }

    // Function that undooms the dice
    public static void undoomDice(ArrayList<Integer> dice1, ArrayList<Integer> dice2) {
        boolean flag = false;
        ArrayList<Integer> elements1 = new ArrayList<>();
        elements1.add(2);
        elements1.add(3);
        int k = 4;
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> elements2 = new ArrayList<>();
        elements2.add(2);
        elements2.add(3);
        elements2.add(4);
        elements2.add(5);
        elements2.add(6);
        elements2.add(7);

        ArrayList<ArrayList<Integer>> ans = makeComb(elements1, k);
        ArrayList<ArrayList<Integer>> ans1 = makeComb(elements2, k);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mp.put(dice1.get(i) + dice2.get(j), mp.getOrDefault(dice1.get(i) + dice2.get(j), 0) + 1);
            }
        }

        int count = 0;
        ArrayList<Integer> answer1 = new ArrayList<>();
        ArrayList<Integer> answer2 = new ArrayList<>();

        for (ArrayList<Integer> an : ans) {
            for (ArrayList<Integer> an1 : ans1) {
                ArrayList<Integer> v1 = new ArrayList<>(an);
                v1.add(1);
                v1.add(4);
                ArrayList<Integer> v2 = new ArrayList<>(an1);
                v2.add(1);
                v2.add(8);
                count++;
                if (isPossible(v1, v2, mp)) {
                    flag = true;
                    answer1 = v1;
                    answer2 = v2;
                    break;
                }
                count++;
            }
            if (flag) {
                break;
            }
            count++;
        }

        System.out.println("The dice1 spots after loki's magic");
        for (Integer e1 : answer1) {
            System.out.print(e1 + ",");
        }
        System.out.println("\nThe dice2 spots after loki's magic");
        for (Integer e2 : answer2) {
            System.out.print(e2 + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> dice1 = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            dice1.add(i);
        }
        ArrayList<Integer> dice2 = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            dice2.add(i);
        }

        //The acceptable repeated elements for diceA because the ocuurence of 12 can be only one such that it is 6+6 before the loki magic and after the occurance of magic the largest element present in the first dice 
    //is 4 and  it can be made as 12 by fixing 4 in the first dice and 8 in the second dice,You may think that 3+9=12 why don't we take that pair and fix 3 in the first dice but the presence of 9 in the second dice with 4 in the first dice can rise to the arise of 13 which lead to the new probability creation so that we are 
    //picking the pair {8,4} and fixing 4 in first dice and 8 in the second dice .So that 4 in the first Dice cannot be repeated more than once.The same scenario is for 1+1=2  where 1 is also fixed in the dice 1 and dice 1 which cannot be repeated

        undoomDice(dice1, dice2);
    }
}

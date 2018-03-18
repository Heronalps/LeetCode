import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Order {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static Map<String, Integer> optimalCombos;
    private static Map<String, Integer> currentCombos;
    private static int minLeftKinds = Integer.MAX_VALUE;

    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();
        Map<String, Integer> res = resolve(order, boms);
        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order,
                                               Map<String, List<Integer>> boms) {
        optimalCombos = new HashMap<>();
        currentCombos = new HashMap<>();
        return resolve(order, boms, 1, 1);
    }

    private static Map<String, Integer> resolve(List<Integer> order,
                                                Map<String, List<Integer>> boms,
                                                int start, int depth) {
        for (int i = start; i <= boms.size(); i++) {
            List<Integer> combo = boms.get("bom" + i);
            if (isValidCombo(order, combo)) {
                deductCombo(order, combo);
                currentCombos.put("bom" + i, currentCombos.getOrDefault("bom" + i, 0) + 1);
                resolve(order, boms, i, depth + 1);
                addCombo(order, combo);
                currentCombos.put("bom" + i, currentCombos.get("bom" + i) - 1);
            }

            else {
                int leftKinds = kindOfItemsInList(order);
                if (leftKinds < minLeftKinds) {
                    minLeftKinds = leftKinds;
                    optimalCombos = new HashMap<>(currentCombos);
                } else if (leftKinds == minLeftKinds) {
                    if (kindOfCombos(currentCombos) < kindOfCombos(optimalCombos)) {
                        optimalCombos = new HashMap<>(currentCombos);
                    }
                }
            }
        }
        return optimalCombos;
    }


    public static int kindOfItemsInList(List<Integer> list) {
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValidCombo(List<Integer> items, List<Integer> combo) {
        for (int i = 0; i < combo.size(); i++) {
            if (items.get(i) < combo.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void deductCombo(List<Integer> items, List<Integer> combo) {
        for (int i = 0; i < combo.size(); i++) {
            items.set(i, items.get(i) - combo.get(i));
        }
    }

    public static void addCombo(List<Integer> items, List<Integer> combo) {
        for (int i = 0; i < combo.size(); i++) {
            items.set(i, items.get(i) + combo.get(i));
        }
    }

    public static int kindOfCombos(Map<String, Integer> combos) {
        int count = 0;
        for(int i = 1; i <= combos.size(); i++) {
            if (combos.getOrDefault("bom" + i, 0) != 0) {
                count++;
            }
        }
        return count;
    }
}

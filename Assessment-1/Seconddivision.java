public class Seconddivision {
    public static void main(String[] args) {
        int sides = 6;
        System.out.println("The distribution for all the pairs when two dice are rolled simultaneously");
        System.out.println("{");
        for (int diceA = 1; diceA <= sides; ++diceA) {
            for (int diceB = 1; diceB <= sides; ++diceB) {
                System.out.print("{" + diceA + "," + diceB + "},");
            }
            System.out.println();
        }
        System.out.println("}");
    }
}

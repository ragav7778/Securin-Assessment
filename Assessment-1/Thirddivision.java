public class  Thirddivision {
    public static void main(String[] args) {
        final int sides = 6;
        final int combinations = sides * sides;
        
        // Initialize the 6x6 matrix for combinations
        int[][] distribution = new int[sides][sides];

        // Calculate and display the distribution
        System.out.println("Die A: Die B: Sum:");
        for (int diceA = 1; diceA <= sides; ++diceA) {
            for (int diceB = 1; diceB <= sides; ++diceB) {
                int sum = diceA + diceB;
                distribution[diceA - 1][diceB - 1]++;
                System.out.println(" " + diceA + "       " + diceB + "      " + sum);
            }
        }

        // Calculate and display the probability of each sum
        System.out.println("\nProbability of each sum:");
        for (int sum = 2; sum <= 12; ++sum) {
            int count = 0;
            for (int diceA = 1; diceA <= sides; ++diceA) {
                int diceB = sum - diceA;
                if (diceB >= 1 && diceB <= sides) {
                    count += distribution[diceA - 1][diceB - 1];
                }
            }
            double probability = (double) count / combinations;
            System.out.println("P(Sum = " + sum + ") = " + "1/" + combinations / count + " = " + probability);
        }
    }
}

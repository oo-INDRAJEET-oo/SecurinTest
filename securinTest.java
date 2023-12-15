import java.util.*;

class securinTest {

    static int power(int number, int pow) {

        if (pow == 0)
            return 1;
        else
            return number * power(number, --pow);
    }

    public static void main(String[] args) {
        int[] dieA = { 1, 2, 3, 4, 5, 6 };
        int[] dieB = { 1, 2, 3, 4, 5, 6 };

        System.out.println("\nPART A");
        System.out.println(
                "\n[1]\nThe combination of possible outcomes for one die will always be the number faces to the power of the outcomes we need. So here it will be 6 to the power 1 for one die. Therefore to get the total number of outcomes when two die is rolled together would just be (6^1*6^1) where we just add the outcomes of the two die. Lets use the {power function} to calculate this: ");

        int outcomes = 1;
        outcomes *= power(dieA.length, 1);
        outcomes *= power(dieB.length, 1);
        System.out.println("The outcome we got is: " + outcomes);

        System.out.println(
                "\n[2]\nThe number of the combination of possible outcomes is simple = number of faces fo dieA * number of faces of dieB , which here is equal to { 6*6=36 }");

        List<Integer>[][] outcomeMatrix = new ArrayList[6][6];

        for (int i = 0; i < dieA.length; i++) {

            for (int j = 0; j < dieB.length; j++) {

                List<Integer> combi = new ArrayList<>();
                combi.add(dieA[i]);
                combi.add(dieB[j]);
                outcomeMatrix[i][j] = combi;

            }

        }

        for (int i = 0; i < dieA.length; i++) {
            for (int j = 0; j < dieB.length; j++)
                System.out.print(outcomeMatrix[i][j] + " ");

            System.out.println();
        }

        System.out.println(
                "\n[3]\nNow for calculating the probability of each outcome the simple formula is : \n\nP(sum(X)) = Total number of outcomes whose sum is X \n\t  --------------------------------------------\n\t\t Total number of outcomes\n");

        for (int i = 2; i <= dieA[dieA.length - 1] + dieB[dieB.length - 1]; i++) {
            int row = 0, col = 0;
            if (i > dieA.length + 1) {
                row = i % (dieA.length + 1);
                col = dieA.length - 1;
            } else {
                row = 0;
                col = i - 2;
            }
            System.out.println("Outcomes for the sum:" + i);
            int count = 0;
            for (int j = row; j < dieA.length && col >= 0; j++) {
                count++;
                System.out.print(outcomeMatrix[j][col--]);
            }
            System.out.println(
                    "\nP(sum(" + i + ")) = " + count + "/" + outcomes + " = " + (float) count / outcomes + "\n");

        }

        System.out.println("\nPART B");

    }
}
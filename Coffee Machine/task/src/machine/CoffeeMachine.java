package machine;
import java.util.*;

public class CoffeeMachine {
    protected static final Scanner sc = new Scanner(System.in);
    //                       water, milk beans cups, $
    private static int[] machine = new int[]{400, 540, 120, 9, 550};
    private static int[] espresso = new int[]{250, 0, 16, 4};
    private static int[] latte = new int[]{350, 75, 20, 7};
    private static int[] cappo = new int[]{200, 100, 12, 6};
    private static int[][] buying = new int[][]{machine, espresso, latte, cappo};

    public static void main(String[] args) {
        ask();
    }

    public static void ask() {
        //Scanner s = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
        String does = sc.next();
        if (does.equals("buy")) {
            buy();

        } else if (does.equals("fill")) {
            fillerup();
        } else if (does.equals("take")) {
            takeit();
        } else if (does.equals("remaining")) {
            System.out.println(outp(buying[0]));
            ask();
        } else {
            System.exit(0);
        }
    }

    private static void takeit() {
        System.out.println("I gave you $" + buying[0][4]);
        buying[0][4] = 0;
        ask();
    }

    private static void fillerup() {
        int[] fill = new int[4];
        System.out.println("Write how many ml of water do you want to add:\n");
        fill[0] = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:\n");
        fill[1] = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:\n");
        fill[2] = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:\n");
        fill[3] = sc.nextInt();
        for (int i = 0; i < fill.length; i++) {
            buying[0][i] += fill[i];
        }
        ask();
    }

    private static void buy() {
        try {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:\n");
            int bought = sc.nextInt();
            String good = enough(bought);
            if (good.equals("yes")) {
                System.out.println("I have enough resources, making you a coffee!");
                for (int i = 0; i < 3; i++) {
                    buying[0][i] -= buying[bought][i];
                }
                buying[0][3] -= 1;
                buying[0][4] += buying[bought][3];
            } else {
                System.out.println("Sorry, not enough " + good + "!\n");
            }
        } catch (Exception e) {
            System.out.println(outp(buying[0]));
        }
        ask();
    }

    public static String outp(int[] m) {
        return "The coffee machine has:\n" +
                m[0] + " of water\n" +
                m[1] + " of milk\n" +
                m[2] + " of coffee beans\n" +
                m[3] + " of disposable cups\n" +
                m[4] + " of money\n";
    }

    public static String enough(int choice) {
        String[] product = new String[]{"water", "milk", "coffee"};
        boolean good = true;
        for (int i = 0; i < 3; i++) {
            if (buying[0][i] < buying[choice][i]) {
                return product[i];
            }
        }
        return "yes";
    }
}

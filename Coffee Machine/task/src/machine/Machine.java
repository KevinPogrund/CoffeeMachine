package machine;

public class Machine {
    private Integer water = 400;
    private Integer milk = 540;
    private Integer beans = 120;
    private Integer cups = 9;
    private Integer money = 550;

    public Machine() {
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                "$" + this.money + " of money";
    }

    public void purchase(int[] drink) {
        // water, milk beans cups, $
        this.water -= drink[0];
        this.milk -= drink[1];
        this.beans -= drink[2];
        this.money += drink[3];
        this.cups -= 1;
    }

    public void fillerup(int[] fill) {
        this.water += fill[0];
        this.milk += fill[1];
        this.beans += fill[2];
        this.cups += fill[3];
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public String enough(int[] bev) {
        if (water < bev[0]) {
            return "water";
        } else if (milk < bev[1]) {
            return "milk";
        } else if (beans < bev[2]) {
            return "coffee beans";
        } else {
            return "yes";
        }
    }
}
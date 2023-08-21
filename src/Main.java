import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < n; i++) {
            String foodName = sc.nextLine();
            Food food = null;
            if (foodName.equals("Egg")) {
                food = new Egg(6.3, 5.3, 0.6); // Using example values
            } else if (foodName.equals("Bread")) {
                food = new Bread(4.0, 1.1, 13.8); // Using example values
            }

            for (int j = 0; j < 3; j++) {
                String method = sc.nextLine();
                switch (method) {
                    case "getMacros":
                        food.getMacroNutrients();
                        break;
                    case "getTaste":
                        food.getTaste();
                        break;
                    case "getType":
                        System.out.println(food.getType());
                        break;
                }
            }
        }
        sc.close();
    }
}
abstract class Food {
    protected double proteins;
    protected double fats;
    protected double carbs;
    protected int tastyScore;

    public abstract void getMacroNutrients();

    public String getType() {
        return "Default type"; // This will be overridden in subclasses
    }

    public void getTaste() {
        System.out.println("Taste: " + tastyScore);
    }
}
class Egg extends Food {
    private String type = "non-vegetarian";

    public Egg(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 7;
    }

    @Override
    public void getMacroNutrients() {
        System.out.println("An egg has " + proteins + " gms of protein, " + fats + " gms of fats and " + carbs + " gms of carbohydrates.");
    }

    @Override
    public String getType() {
        return "Egg is " + type;
    }
}
class Bread extends Food {
    private String type = "vegetarian";

    public Bread(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 8;
    }

    @Override
    public void getMacroNutrients() {
        System.out.println("A slice of bread has " + proteins + " gms of protein, " + fats + " gms of fats and " + carbs + " gms of carbohydrates.");
    }

    @Override
    public String getType() {
        return "Bread is " + type;
    }
}
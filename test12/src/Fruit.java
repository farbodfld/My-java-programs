import java.util.*;

public class Fruit {
    public String color;

    public Fruit(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + "fruit";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(color, fruit.color);
    }

    @Override
    public int hashCode() {
        return color.length();
    }
}

class Test {
    public static void main(String[] args) {
        Map<Fruit, Integer> fruit = new HashMap<>();
        Fruit f1 = new Fruit("red");
        Fruit f2 = new Fruit("yellow");
        Fruit f3 = new Fruit("yellow");
        Fruit f4 = new Fruit("orange");

        fruit.put(f1, 2);
        fruit.put(f2, 1);
        fruit.put(f3, 1);
        fruit.put(f4, 3);

        System.out.println(fruit);
    }
}
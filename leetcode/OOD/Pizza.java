package OOD;
import java.util.*;

// Problem Description: The main task is to design a system for calculating pizza prices, with several follow-up questions exploring various OOD aspects.


// The initial setup involves a pizza with toppings, base, and size.


// Key Follow-up Questions:
// How to handle additional items like Coke and Wings in the order system
// How to implement a coupon system for the entire order
// How to implement a buy-one-get-one-free coupon system
// How to handle free toppings and where to place this logic
// How to handle different store configurations with varying prices

public class Pizza {
    private Base base;
    private Size size;
    private List<Topping> toppings;

    public Pizza(Base base, Size size, List<Topping> toppings) {
        this.base = base;
        this.size = size;
        this.toppings = toppings;
    }

    public double getPrice() {
        // base price
        double price = size.getPrice() + base.getPrice();
        // topping price
        for(Topping topping : toppings) {
            price += topping.getPrice();
        }
        return price;
    }
    public static void main(String[] args) {
        // Topping pineapple = new Topping("pineapple", 2);
        // Topping cheese = new Topping("cheese", 1);
        // List<Topping> toppings1 = List.of(
        //     pineapple
        // );
        // Base thinCrust = new Base("thin", 1);
        // Base deepDish = new Base("deep", 2);
        // Pizza pineapplePizza = new Pizza(thinCrust, Size.SMALL, toppings1);
        // System.out.println("The total price is: " + pineapplePizza.getPrice());
        Pizza pineapplePizza = PizzaFactory.createPizza("pineapple pizza");
        Pizza veggiePizza = PizzaFactory.createPizza("veggie");
        System.out.println("Price: $" + (pineapplePizza.getPrice() + veggiePizza.getPrice()));
    }
}

class Base {
    private final String name;
    private final double price;
    public Base(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}


enum Size {
    SMALL(5.0), MEDIUM(7.0), LARGE(9.0);

    private final double price;

    Size(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}

class Topping {
    private final String name;
    private final int price;
    Topping(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
// factory class: 工厂类是一种封装“对象创建逻辑”的类，用来创建特定类型的对象，避免在主程序中写大量 new
class PizzaFactory {
    public static Pizza createPizza(String name) {
        switch(name.toLowerCase()) {
            case "pineapple pizza":
                return new Pizza(
                    new Base("thin crust", 1),
                    Size.SMALL,
                    Arrays.asList(
                        new Topping("pineapple", 2),
                        new Topping("cheese", 1)
                    )
                );
            case "veggie":
            return new Pizza(
                new Base("deep dish", 2),
                Size.LARGE,
                Arrays.asList(
                    new Topping("mushroom", 3),
                    new Topping("onion", 1)
                )
            );
            default:
                throw new IllegalArgumentException("Unknown menu item " + name);
        }
    }
}





package ru.skillbox;

public class Cat extends Animal implements MayDrink, MayEat {

    static int catsCounter = 0;

    private final double ORIGINAL_WEIGHT;
    private double weight;
    private AnimalColour colour;
    private double foodCounter = 0;

    private static final double MIN_WEIGHT = 100;
    private static final double MAX_WEIGHT = 9000;

    public Cat(double ORIGINAL_WEIGHT, AnimalColour colour) {
        if (ORIGINAL_WEIGHT >= MIN_WEIGHT || ORIGINAL_WEIGHT <= MAX_WEIGHT) {
            this.ORIGINAL_WEIGHT = ORIGINAL_WEIGHT;
            this.weight = ORIGINAL_WEIGHT;
            this.colour = colour;
            catsCounter++;
        } else {
            throw new RuntimeException("Не бывает котов с таким весом!!!");
        }
    }


    //todo
    public void sayMeow() {
        if (isAlive()){
            System.out.println("MEOW");
        }
    }

    public double getWeight() {
        return weight;
    }

    public AnimalColour getColour() {
        return colour;
    }

    public void setColour(AnimalColour colour) {
        this.colour = colour;
        System.out.println("Зачем было перекрашивать кошечку?");
    }

    @Override
    public void feed(Double amount) {
        if (isAlive()) {
            weight = +amount;
            foodCounter = +amount;
        } else throw new RuntimeException("Мёртвые кошечки не кушают =(((((((");
    }

    @Override
    public void drink(Double amount) {
        if (isAlive()) {
            weight = +amount;
        } else throw new RuntimeException("Мёртвые кошечки не пьют =(((((((");
    }

    public void pee() {
        if (isAlive()) {
            this.weight = -100;
            System.out.println("Хозяин, время почистить мой лоточек!");
        } else throw new RuntimeException("Мёртвые кошечки не ходят в туалет =(((((((");
    }

    public double getFoodCounter() {
        return foodCounter;
    }

    public boolean isAlive() {
        if (getStatus().equalsIgnoreCase("Dead") ||
                getStatus().equalsIgnoreCase("Exploded")) {
            return false;
        } else return true;
    }

    @Override
    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded"; // взорван
        } else if (weight > ORIGINAL_WEIGHT) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}

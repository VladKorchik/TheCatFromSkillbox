package ru.skillbox.model.animal.cat;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.model.animal.Animal;
import ru.skillbox.model.animal.AnimalColour;
import ru.skillbox.model.animal.MayDrink;
import ru.skillbox.model.animal.MayEat;

@Getter
@Setter
public class Cat extends Animal implements MayDrink, MayEat {

    private static final double MIN_WEIGHT = 100;
    private static final double MAX_WEIGHT = 9000;
    public static int catsCounter = 0;

    private final int NUMBER_OF_EYES = 2;
    private final double ORIGINAL_WEIGHT;
    private double weight;
    private AnimalColour colour;
    private double foodCounter = 0;
    private boolean hasTail;

    public Cat(double ORIGINAL_WEIGHT, AnimalColour colour, boolean hasTail) {
        if (ORIGINAL_WEIGHT >= MIN_WEIGHT || ORIGINAL_WEIGHT <= MAX_WEIGHT) {
            this.ORIGINAL_WEIGHT = ORIGINAL_WEIGHT;
            this.weight = ORIGINAL_WEIGHT;
            this.colour = colour;
            this.hasTail = hasTail;
            catsCounter++;
        } else {
            throw new RuntimeException("Не бывает котов с таким весом!!!");
        }
    }

    public void sayMeow() {
        if (isAlive()) {
            System.out.println("MEOW");
            weight = weight - 100;
            if (!isAlive()) {
                killTheCat();
            }
        }
    }

    @Override
    public void feed(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            foodCounter = +amount;
            if (!isAlive()) {
                killTheCat();
            }
        } else throw new RuntimeException("Мёртвые кошечки не кушают =(((((((");
    }

    @Override
    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            if (!isAlive()) {
                killTheCat();
            }
        } else throw new RuntimeException("Мёртвые кошечки не пьют =(((((((");
    }

    public void pee() {
        if (isAlive()) {
            this.weight = weight - 100;
            System.out.println("Хозяин, время почистить мой лоточек!");
            if (!isAlive()) {
                killTheCat();
            }
        } else throw new RuntimeException("Мёртвые кошечки не ходят в туалет =(((((((");
    }

    @Override
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
            return "Exploded";
        } else if (weight > ORIGINAL_WEIGHT) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    protected void killTheCat() {
        System.out.println("Кажется, кошечка умерла :'(((");
        catsCounter = catsCounter - 1;
    }
}
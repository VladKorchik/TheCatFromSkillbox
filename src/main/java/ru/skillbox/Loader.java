package ru.skillbox;

import ru.skillbox.model.animal.cat.Cat;
import static ru.skillbox.model.animal.AnimalColour.*;
import static ru.skillbox.model.animal.cat.Cat.catsCounter;

public class Loader {
    public static void main(String[] args) {

        Cat sally = new Cat(3000, ORANGE, true);
        System.out.println("Вес Салли = " + sally.getWeight());
        sally.feed(100.0);
        System.out.println("Вес Салли = " + sally.getWeight());

        System.out.println("Сейчас всего кошечек: " + catsCounter);

        Cat liza = new Cat(2000, SKIN, false);
        System.out.println("Вес Лизы  = " + liza.getWeight());
        liza.drink(50.0);
        System.out.println("Вес Лизы  = " + liza.getWeight());

        System.out.println("Сейчас всего кошечек: " + catsCounter);

        while (sally.isAlive()) {
            sally.feed(150.0);
            System.out.println(sally.getWeight());
        }

        while (liza.isAlive()) {
            liza.sayMeow();

        }

        System.out.println("Сейчас всего кошечек: " + catsCounter);
    }

}

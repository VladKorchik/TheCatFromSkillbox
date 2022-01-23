package ru.skillbox.model.animal.cat;

import ru.skillbox.model.animal.Animal;
import ru.skillbox.model.animal.AnimalColour;

public class KittenBuilder {
    final static double KITTEN_WEIGHT = 1100;

    public Animal createKitten (AnimalColour colour, boolean hasTail) {

        Animal kitten = new Cat(KITTEN_WEIGHT, colour, hasTail);
        return kitten;

    }

}

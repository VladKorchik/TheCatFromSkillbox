package ru.skillbox.model.animal;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    public abstract boolean isAlive();

    public abstract String getStatus();



}

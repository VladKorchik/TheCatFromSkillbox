package ru.skillbox.model.animal.cat;

import ru.skillbox.model.animal.Animal;
import java.io.*;

public class CatsCloner {

    public Animal cloneCat (Animal cat) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(cat);
        objectOutputStream.flush();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        byte[] byteData = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
        Cat newCat = (Cat) new ObjectInputStream(bais).readObject();

        return newCat;

    }

}

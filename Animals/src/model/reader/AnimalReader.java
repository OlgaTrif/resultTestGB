package model.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AnimalReader implements AnimalReaderable {
    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filePath)))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

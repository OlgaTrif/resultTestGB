package model.writer;

import model.animal.Animal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class AnimalWriter implements AnimalWritable{
    @Override
    public boolean write(List<Animal> serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}

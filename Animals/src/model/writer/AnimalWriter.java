package model.writer;

import model.animal.Animal;
import model.animal.AnimalList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AnimalWriter implements AnimalWritable{
    @Override
    public boolean write(AnimalList<Animal> serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}

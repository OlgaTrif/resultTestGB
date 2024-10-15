package model.writer;

import model.animal.Animal;
import model.animal.AnimalList;

public interface AnimalWritable {
    boolean write(AnimalList<Animal> serializable, String filePath);
}

package model.writer;

import model.animal.Animal;

import java.util.List;

public interface AnimalWritable {
    boolean write(List<Animal> serializable, String filePath);
}

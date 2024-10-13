package model.writer;

import model.animal.AnimalList;

public interface AnimalWritable {
    boolean write(AnimalList<Object> serializable, String filePath);
}

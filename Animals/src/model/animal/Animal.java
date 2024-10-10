package model.animal;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface Animal {
    String getName();
    void setName(String name);
    LocalDate getDateOfBirth();
    void setDateOfBirth(LocalDate date);
    LocalDate getDateOfDeath();
    List<String> getCommandList();
    int getCommandCount();
    void setDateOfDeath(LocalDate date);
    void addCommand(String newCommand);
    void removeCommand(String command);
}

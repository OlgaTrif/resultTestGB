package model.pet.hamster;

import model.animal.Animal;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Hamster implements Animal {
    private String name;
    private ArrayList<String> commands;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Hamster() {
        this("", new ArrayList<>(), LocalDate.now(), LocalDate.now());
    }

    public Hamster(String name, ArrayList<String> commands, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.commands = commands;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Hamster(String name, ArrayList<String> commands, LocalDate dateOfBirth) {
        this.name = name;
        this.commands = commands;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate date) {
        this.dateOfBirth = date;
    }

    @Override
    public LocalDate getDateOfDeath() {
        return this.dateOfDeath;
    }

    @Override
    public List<String> getCommandList() {
        return this.commands;
    }

    @Override
    public int getCommandCount() {
        return this.commands.size();
    }

    @Override
    public void setDateOfDeath(LocalDate date) {
        this.dateOfDeath = date;
    }

    @Override
    public void addCommand(String newCommand) {
        this.commands.add(newCommand);
    }

    @Override
    public void removeCommand(String command) {
        this.commands.remove(command);
    }

    public Integer getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period between;
        between = Period.between(dateOfBirth, Objects.requireNonNullElseGet(dateOfDeath, LocalDate::now));
        return between.getYears();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(getName());
        sb.append("; возраст: ");
        sb.append(getAge(getDateOfBirth(), getDateOfDeath()));
        sb.append("; команды: ");
        sb.append(getCommandList().toString());
        return sb.toString();
    }
}

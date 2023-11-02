package Nursery.model.animals;

import Nursery.model.Animal;

public class Cat extends Animal {
    public Cat(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Commands for cat " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Cat " + getName() + " learned new command: " + command);
    }
}

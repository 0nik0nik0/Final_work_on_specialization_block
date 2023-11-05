package Nursery.model.animals;

import Nursery.model.Animal;

public class Horse extends Animal {
    public Horse(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("List of commands for horse:");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Horse " + getName() + " learned new command: " + command);
    }
}

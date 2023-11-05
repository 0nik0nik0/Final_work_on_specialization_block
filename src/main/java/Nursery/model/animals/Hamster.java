package Nursery.model.animals;

import Nursery.model.Animal;

public class Hamster extends Animal {
    public Hamster(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("List of commands for hamster:");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Hamster " + getName() + " learned new command: " + command);
    }
}

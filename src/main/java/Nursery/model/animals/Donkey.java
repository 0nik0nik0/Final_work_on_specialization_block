package Nursery.model.animals;

import Nursery.model.Animal;

public class Donkey extends Animal {
    public Donkey(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("List of commands for the donkey:");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Donkey " + getName() + " learned new command: " + command);
    }
}

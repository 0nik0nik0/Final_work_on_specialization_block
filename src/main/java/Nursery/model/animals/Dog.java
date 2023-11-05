package Nursery.model.animals;

import Nursery.model.Animal;

public class Dog extends Animal {
    public Dog(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("List of commands for the dog:");
        System.out.println(getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Dog " + getName() + " learned new command: " + command);
    }
}

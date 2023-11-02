package Nursery.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import Nursery.controller.Controller;
import Nursery.model.Animal;
import Nursery.model.animals.*;

public class View {
    private final Controller controller;
    private final Scanner scanner;

    public View(Controller database) {
        this.controller = database;
        scanner = new Scanner(System.in);
    }
    // Показать перечень возможных действий

    public void displayView() {
        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Add a new animal");
                System.out.println("2. Show a list of all animals");
                System.out.println("3. View the list of animal commands");
                System.out.println("4. Train an animal");
                System.out.println("0. Exit");
                System.out.print("Select a menu item and press 'Enter': ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addNewAnimal();
                    case 2 -> controller.displayAllAnimals();
                    case 3 -> displayAnimalCommands();
                    case 4 -> teachNewCommand();
                    case 0 -> {
                        System.out.println("The program is completed.");
                        return;
                    }
                    default -> System.out.println("Incorrect input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input format. Try again.");
                scanner.nextLine();
            }
        }
    }

    // Добавить животное

    private void addNewAnimal() {
        System.out.println("Enter the name of the animal:");
        String name = scanner.nextLine();
        System.out.println("Enter a comma-separated list of commands:");
        String skills = scanner.nextLine();

        System.out.println("Choose an animal class:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Hamster");
        System.out.println("4. Donkey");
        System.out.println("5. Horse");
        System.out.println("6. Camel");
        int animalClass = scanner.nextInt();
        scanner.nextLine();

        Animal animal;
        switch (animalClass) {
            case 1 -> animal = new Dog(name, skills);
            case 2 -> animal = new Cat(name, skills);
            case 3 -> animal = new Hamster(name, skills);
            case 4 -> animal = new Donkey(name, skills);
            case 5 -> animal = new Horse(name, skills);
            case 6 -> animal = new Camel(name, skills);
            default -> {
                System.out.println("Wrong choice of animal class.");
                return;
            }
        }

        controller.addAnimal(animal);
        System.out.println("The animal has been added successfully");
    }
    // Отобразить команды животного
    private void displayAnimalCommands() {
        System.out.println("Enter the name of the animal:");
        String name = scanner.nextLine();

        controller.displayAnimalCommands(name);
    }
    //Добавление команды животному
    private void teachNewCommand() {
        System.out.println("Enter the name of the animal:");
        String name = scanner.nextLine();
        System.out.println("Enter new commands separated by commas:");
        String command = scanner.nextLine();

        controller.teachNewCommand(name, command);
        System.out.println("Command successfully added for animal.");
    }
}

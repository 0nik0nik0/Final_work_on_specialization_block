package Nursery.controller;

import java.io.*;
import java.util.*;

import Nursery.model.Animal;
import Nursery.model.animals.*;

public class Controller {
	private final List<Animal> animals;
	private static final String FILE_PATH = "src/main/java/Nursery/newAnimalsList.txt";

	Counter myCounter;
	public Controller() {
		animals = new ArrayList<>();
		loadAnimalsList();
		myCounter = new Counter();
	}

	//Добавить животное
	public void addAnimal(Animal animal) {
		animals.add(animal);
		saveAnimalsList();
		try {
            myCounter.add();
			System.out.println(myCounter);

        } catch (NullPointerException e) {
            System.out.println("Error");
		}
	}

	//Показать команды животного
	public void displayAnimalCommands(String name) {
		for (Animal animal : animals) {
			if (animal.getName().equals(name)) {
				animal.displayCommands();
				return;
			}
		}
		System.out.println("An animal with  name " + name + " not found.\n");
	}

	//Научить животное новой команде 
	public void teachNewCommand(String name, String command) {
		for (Animal animal : animals) {
			if (animal.getName().equals(name)) {
				String[] commands = command.split(",");
				for (int i = 0; i < commands.length; i++) {
					String trimmedCommand = commands[i].trim();
					commands[i] = trimmedCommand;
				}
				animal.teachNewCommand(command);
				saveAnimalsList();
				System.out.println("Command successfully added.\n");
				return;
			}
		}
		System.out.println("An animal with name " + name + " not found.\n");
	}

	//Загрузка
	
	private void loadAnimalsList() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length >= 3) {
					String className = data[0];
					String name = data[1];
					String skills = String.join(",", Arrays.copyOfRange(data, 2, data.length));

					Animal animal;
					switch (className) {
						case "Dog" -> animal = new Dog(name, skills);
						case "Cat" -> animal = new Cat(name, skills);
						case "Hamster" -> animal = new Hamster(name, skills);
						case "Donkey" -> animal = new Donkey(name, skills);
						case "Horse" -> animal = new Horse(name, skills);
						case "Camel" -> animal = new Camel(name, skills);
						default -> {
							System.out.println("Unknown animal class: " + className);
							continue;
						}
					}
					animals.add(animal);
				} else {
					System.out.println("Incorrect data in the file: " + line);
				}
			}
			System.out.println("Uploaded successfully\n");
		} catch (IOException e) {
			System.out.println("Error reading: " + e.getMessage());
		}
	}

	//Показать всех животных

	public void displayAllAnimals() {
		try {
			File file = new File(FILE_PATH);
			Scanner fileScanner = new Scanner(file);

			while (fileScanner.hasNextLine()) {
				String animalData = fileScanner.nextLine();
				System.out.println(animalData);
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Animal data file not found.\n");
		}
	}

	//Сохранение

	private void saveAnimalsList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Animal animal : animals) {
				String className = animal.getClass().getSimpleName();
				String name = animal.getName();
				String skills = animal.getSkills().replaceAll(",\\s+", ",");

				String line = className + "," + name + "," + skills;
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Successfully saved.\n");
		} catch (IOException e) {
			System.out.println("Error when saving: " + e.getMessage());
		}
	}

}

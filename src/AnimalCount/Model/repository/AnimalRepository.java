package AnimalCount.Model.repository;

import AnimalCount.Model.Animal;
import AnimalCount.Model.InheritanceClasses.*;
import AnimalCount.util.AnimalMaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AnimalRepository implements GBRepositoty{
    private final AnimalMaper mapper;
    private final FileOperation operation;

    public AnimalRepository(FileOperation operation) {
        this.mapper = new AnimalMaper();
        this.operation = operation;
    }

    @Override
    public List<Animal> findAll() {
        List<String> lines = operation.readAll();
        List<Animal> animals = new ArrayList<>();
        for (String line : lines) {
            animals.add(mapper.toOutput(line));
        }
        return animals;
    }

    @Override
    public Animal create(Animal animal) {
        List<Animal> animals = findAll();
        long max = 0L;
        for (Animal u : animals) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        animal.setId(next);
        animals.add(animal);
        write(animals);
        return animal;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Animal> update(Long userId, Animal update) {
        List<Animal> animals = findAll();
        Animal editAnimal = animals.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));

        if(!update.getNameAnimal().isEmpty()){
            editAnimal.setNameAnimal(update.getNameAnimal());
        }else{
            editAnimal.setNameAnimal(editAnimal.getNameAnimal());
        }

        if(!update.getCommands().isEmpty()){
            editAnimal.setCommands(update.getCommands());
        }else{
            editAnimal.setCommands(editAnimal.getCommands());
        }

        if(!update.getDateBirth().isEmpty()){
            editAnimal.setDateBirth(update.getDateBirth());
        }else{
            editAnimal.setDateBirth(editAnimal.getDateBirth());
        }

        write(animals);
        return Optional.of(update);
    }

    @Override
    public boolean delete(Long id) {
        List<Animal> animals = findAll();
        List<Animal> tmp = new ArrayList<>();
        Long idTmp = 1L;

        for (Animal animal : animals) {

            if(animal.getId().equals(id)){
                animals.remove(animal);
                System.out.println("Animal " + animal.getId() + " was successfully deleted!");
            }
            tmp.add(animal);
            animal.setId(idTmp);
            idTmp++;
        }
        write(tmp);
        return true;
    }

    private void write(List<Animal> animals) {
        List<String> lines = new ArrayList<>();
        for (Animal u: animals) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }
    @Override
    public Animal createTemporaryAnimal() {
        String typeName = prompt("Животное: ");
        String command = prompt("Команда: ");
        String dateBirth = prompt("Дата рождения: ");
        String typeOfAnimal = prompt("Input type of animal: ");
        if (typeOfAnimal.equals("Camel")){
           Animal camel = new Camel(typeName, command, dateBirth);
           ((Camel) camel).type();
            return camel;
        }
        else if (typeOfAnimal.equals("Dog")) {
             Animal dog = new  Dog(typeName, command, dateBirth);
             return dog;
        }
        else if (typeOfAnimal.equals("Cat")) {
            Animal cat = new Cat(typeName, command, dateBirth);
            return cat;
        }
        else if (typeOfAnimal.equals("Rabbit")) {
            Animal rabbit = new Rabbit(typeName, command, dateBirth);
            return rabbit;
        }
        else if (typeOfAnimal.equals("Horse")) {
            Animal horse = new Horse(typeName, command, dateBirth);
            return horse;
        }
        else if (typeOfAnimal.equals("Donkey")) {
            Animal donkey = new Donkey(typeName, command, dateBirth);
            return donkey;
        }
        System.out.println("Добавленно животное не из списка возможных");
        return new Animal(typeName, command, dateBirth);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}

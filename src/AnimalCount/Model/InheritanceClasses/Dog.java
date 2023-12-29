package AnimalCount.Model.InheritanceClasses;

import AnimalCount.Model.Animal;
import AnimalCount.Model.PetsAnimals;

public class Dog extends Animal implements PetsAnimals {
    public Dog(String nameAnimal, String commands, String dateBirth) {
        super(nameAnimal, commands, dateBirth);
    }

    public Dog(Long id, String nameAnimal, String commands, String dateBirth) {
        super(id, nameAnimal, commands, dateBirth);
    }

    @Override
    public void type() {

        System.out.println("Класс домашние животные, " + getClass().getSimpleName()  +  "  - живу в доме");
    }
}

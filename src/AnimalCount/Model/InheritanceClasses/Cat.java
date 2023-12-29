package AnimalCount.Model.InheritanceClasses;

import AnimalCount.Model.Animal;
import AnimalCount.Model.PetsAnimals;

public class Cat extends Animal implements PetsAnimals {
    public Cat(String nameAnimal, String commands, String dateBirth) {
        super(nameAnimal, commands, dateBirth);
    }

    public Cat(Long id, String nameAnimal, String commands, String dateBirth) {
        super(id, nameAnimal, commands, dateBirth);
    }

    @Override
    public void type() {

        System.out.println("Класс домашние животные, " + getClass().getSimpleName()  +  "  - живу в доме");
    }
}

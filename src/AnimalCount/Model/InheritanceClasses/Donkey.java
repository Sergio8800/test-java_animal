package AnimalCount.Model.InheritanceClasses;

import AnimalCount.Model.Animal;
import AnimalCount.Model.PackAnimals;

public class Donkey extends Animal implements PackAnimals {
    public Donkey(String nameAnimal, String commands, String dateBirth) {
        super(nameAnimal, commands, dateBirth);
    }

    public Donkey(Long id, String nameAnimal, String commands, String dateBirth) {
        super(id, nameAnimal, commands, dateBirth);
    }

    @Override
    public void type() {
        System.out.println("Класс вьючные животные, " + getClass().getSimpleName()  +  "  - живу на улице");
    }
}

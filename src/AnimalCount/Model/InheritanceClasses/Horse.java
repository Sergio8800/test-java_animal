package AnimalCount.Model.InheritanceClasses;

import AnimalCount.Model.Animal;
import AnimalCount.Model.PackAnimals;

public class Horse extends Animal implements PackAnimals {
    public Horse(String nameAnimal, String commands, String dateBirth) {
        super(nameAnimal, commands, dateBirth);
    }

    public Horse(Long id, String nameAnimal, String commands, String dateBirth) {
        super(id, nameAnimal, commands, dateBirth);
    }

    @Override
    public void type() {
        System.out.println("Класс вьючные животные, " + getClass().getSimpleName()  +  "  - живу на улице");
    }
}

package AnimalCount.Model.InheritanceClasses;

import AnimalCount.Model.Animal;
import AnimalCount.Model.PackAnimals;

public class Camel extends Animal implements PackAnimals {
    public Camel(String nameAnimal, String commands, String dateBirth) {
        super(nameAnimal, commands, dateBirth);
    }

    public Camel(Long id, String nameAnimal, String commands, String dateBirth) {
        super(id, nameAnimal, commands, dateBirth);
    }

    @Override
    public void type() {
        System.out.println("Класс вьючные животные, " + getClass().getSimpleName()  +  "  - живу на улице");
    }

}

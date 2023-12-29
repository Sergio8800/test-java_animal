package AnimalCount.util;

import AnimalCount.Model.Animal;

public interface Mapper {
    String toInput(Animal e);
    Animal toOutput(String str);
}

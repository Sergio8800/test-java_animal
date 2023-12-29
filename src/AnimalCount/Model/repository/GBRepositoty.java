package AnimalCount.Model.repository;

import AnimalCount.Model.Animal;

import java.util.List;
import java.util.Optional;

public interface GBRepositoty {
    List<Animal> findAll();
    Animal create(Animal animal);
    Optional<Animal> findById(Long id);
    Optional<Animal> update(Long userId, Animal update);
    boolean delete(Long id);
    Animal createTemporaryAnimal();
//    Animal createTypeAnimal();
}

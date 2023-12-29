package AnimalCount.Controller;

import AnimalCount.Model.Animal;
import AnimalCount.Model.repository.GBRepositoty;

import java.util.List;
import java.util.Objects;

public class Controller {
    private final GBRepositoty repository;

    public Controller(GBRepositoty repository) {
        this.repository = repository;
    }

    public void saveAnimal(Animal animal) {
        repository.create(animal);
    }

    public Animal readAnimal(Long userId) throws Exception {
        List<Animal> animals = repository.findAll();
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), userId)) {
                return animal;
            }
        }

        throw new RuntimeException("Animal not found");
    }

    public void updateAnimal(String userId, Animal update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }

    public void deleteAnimal(String userId) {
        repository.delete(Long.parseLong(userId));
    }

    public List<Animal> readAll() {
        return repository.findAll();
    }

    public Animal createAnimal() {
        return repository.createTemporaryAnimal();
    }

}

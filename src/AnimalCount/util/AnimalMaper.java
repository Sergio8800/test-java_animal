package AnimalCount.util;

import AnimalCount.Model.Animal;

public class AnimalMaper implements Mapper{
    @Override
    public String toInput(Animal animal) {
        return String.format("%s,%s,%s,%s", animal.getId(), animal.getNameAnimal(), animal.getCommands(), animal.getDateBirth());
    }

    @Override
    public Animal toOutput(String s) {
        String[] lines = s.split(",");
        long id;
        if (isDigit(lines[0])) {
            id = Long.parseLong(lines[0]);
            return new Animal(id, lines[1], lines[2], lines[3]);
        }
        throw new NumberFormatException("IT must be a large number");
    }
    public Animal toOutputDelete(String s) {
        String[] lines = s.split(",");
        long id=1;
        return new Animal(id, lines[1], lines[2], lines[3]);

    }

    private boolean isDigit(String s) throws NumberFormatException{
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

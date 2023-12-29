package AnimalCount.Model;

public class Animal {
    private Long id;
    private String nameAnimal;
    private String commands;
    private String dateBirth;

    public Animal(String nameAnimal, String commands, String dateBirth) {
        this.nameAnimal = nameAnimal;
        this.commands = commands;
        this.dateBirth = dateBirth;
    }

    public Animal(Long id, String nameAnimal, String commands, String dateBirth) {
        this(nameAnimal, commands, dateBirth);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s ИмяЖивотного: %s, Команды: %s, датаРождения: %s \n", id, nameAnimal, commands, dateBirth);
    }

}

package AnimalCount.view;

import AnimalCount.Controller.Controller;
import AnimalCount.Model.Animal;
import AnimalCount.util.Commands;

import java.util.List;
import java.util.Scanner;

public class AnimalView {
    Scanner sc = new Scanner(System.in);
    private final Controller Controller;

    public AnimalView(Controller userController) {
        this.Controller = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            printActions();
            String command = sc.nextLine();
            System.out.println("-".repeat(30));
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case SHOW:
                case S:
                    List<Animal> animals = Controller.readAll();
                    System.out.println(animals);
                    break;
                case CREATE:
                case C:
                    Controller.saveAnimal(Controller.createAnimal());
                    break;
                case READ:
                case R:
                    System.out.print("Введите id animal для просмотра ");
                    String id = sc.nextLine();
                    try {
                        Animal animal = Controller.readAnimal(Long.parseLong(id));
                        System.out.println(animal);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                case D:
                    System.out.print("Введите id animal для удаления ");
                    String id1 = sc.nextLine();
                    Controller.deleteAnimal(id1);
                    break;
                case UPDATE:
                case U:
                    System.out.println("Введите id animal для модернизации ");
                    String userId = sc.nextLine();
                    Controller.updateAnimal(userId, Controller.createAnimal());
            }
        }
    }

    private void printActions(){
        String textBlock = """
                Available actions:
                EXIT -> GO OUT
                SHOW OR S
                CREATE OR C
                READ OR R
                UPDATE OR U
                DELETE OR D
                
                Введите необходимую команду:""";
        System.out.print(textBlock + " ");
    }
}

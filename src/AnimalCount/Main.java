package AnimalCount;

import AnimalCount.Controller.Controller;
import AnimalCount.Model.Animal;
import AnimalCount.Model.InheritanceClasses.Camel;
import AnimalCount.Model.repository.FileOperation;
import AnimalCount.Model.repository.GBRepositoty;
import AnimalCount.Model.repository.AnimalRepository;
import AnimalCount.view.AnimalView;

import static AnimalCount.util.DBConnector.DB_PATH;
import static AnimalCount.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
        FileOperation fileOperation = new FileOperation(DB_PATH);
        GBRepositoty repository = new AnimalRepository(fileOperation);
        Controller controller = new Controller(repository);
        AnimalView view = new AnimalView(controller);
        view.run();
//        Animal camel = new Camel("kkkkkk", "kkkkkkka","123414");
//        ((Camel) camel).type();
//        String typeOfAnimal =  prompt("dd");
//        if (typeOfAnimal == "Camel"){
//            Animal camel1 = new Camel("kkkkkk", "kkkkkkka","123414");
//            ((Camel) camel1).type();
//
    }
}

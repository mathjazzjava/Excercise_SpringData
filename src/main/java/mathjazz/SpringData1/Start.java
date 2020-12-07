package mathjazz.SpringData1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
    
    private CarRepo carRepo;
    
    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Car car1 = new Car("Honda", "Civic", Color.BLUE);    //tworzenie nowego przedstawiciela klasy Car
        carRepo.save(car1);                                             //dodawanie rekordu do bazy

        Car car2 = new Car("Opel", "Astra", Color.BLACK);
        carRepo.save(car2);

        Car car3 = new Car("Seat", "Leon", Color.WHITE);
        carRepo.save(car3);

        Car car4 = new Car("Ford", "Focus", Color.RED);
        carRepo.save(car4);

        System.out.println("Wszystkie samochody z bazy: ");
        Iterable<Car> all = carRepo.findAll();
        all.forEach(System.out::println);

        System.out.println("Samochody po usunięciu nr 3:");
        carRepo.deleteById(3L);                             //usuwanie rekordu o podanym id
        Iterable<Car> all2 = carRepo.findAll();             //wyszukiwanie rekordów w bazie
        all2.forEach(System.out::println);                  //pobieranie rekordu z bazy danych do okna konsoli

        System.out.println("Samochody o kolorze RED:");
        Iterable<Car> all3 = carRepo.findAllByColor(Color.RED);            //wyszukiwanie rekordów w bazie po kolorze
        all3.forEach(System.out::println);
    }
    
}

package mathjazz.SpringData1;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
    
    List<Car> findAllByColor(Color color);
}

package mathjazz.SpringData1;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="MyCar")    //adnotacja zmieniająca nazwę tabeli
public class Car {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String mark;
    
    //@Transient              //powoduje niezapisywanie danego pola do bazy danych
    private String model;
    
    @Enumerated(EnumType.STRING)    //powoduje, że ENUMy są widoczne w bazie jako Stringi, a nie liczby
    private Color color;

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }
    
    public Long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", mark=" + mark + ", model=" + model + ", color=" + color + '}';
    }
    
    
    
}

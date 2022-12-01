package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString(exclude = {"car"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @OneToOne(mappedBy = "manager")
    private Car car;

    public Manager(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void setCar(Car car) {
        if (car == null){
            if (this.car == null) return;
            this.car.setManager(null);
            this.car = null;
            return;
        }
        car.setManager(this);
        this.car = car;
    }
}

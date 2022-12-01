package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car implements Serializable {
    @Id
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(nullable = false)
    private String model;

    @OneToOne
    @JoinTable(name = "CarManager",
            joinColumns = @JoinColumn(name = "reg_no", referencedColumnName = "registration_number"),
            inverseJoinColumns = @JoinColumn(name = "m_id", referencedColumnName = "id",
                    unique = true, nullable = false))
    private Manager manager;

    public Car(String registrationNumber, String model) {
        this.registrationNumber = registrationNumber;
        this.model = model;
    }
}

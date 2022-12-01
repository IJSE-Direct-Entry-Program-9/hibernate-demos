package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car2 implements Serializable {
    @Id
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(nullable = false)
    private String model;
}

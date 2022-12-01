package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile implements Serializable {
    @Id
    private String imie;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String number;
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, unique = true)
    private Student student;
}

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
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id"}))
public class Spouse implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false,
            unique = true)
    private Employee employee;
}

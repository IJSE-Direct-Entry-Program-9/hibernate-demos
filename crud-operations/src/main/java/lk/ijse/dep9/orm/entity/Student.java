package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;

    public Student(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}

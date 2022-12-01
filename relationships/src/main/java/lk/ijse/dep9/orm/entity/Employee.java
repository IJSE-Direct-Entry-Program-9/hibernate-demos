package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@ToString(exclude = "spouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contact;
//    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "employee")
    private Spouse spouse;

    public Employee(String id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public void setSpouse(Spouse spouse) {
        spouse.setEmployee(this);
        this.spouse = spouse;
    }
}

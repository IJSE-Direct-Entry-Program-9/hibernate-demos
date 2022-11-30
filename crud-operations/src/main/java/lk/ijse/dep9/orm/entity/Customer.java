package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer implements Serializable {
    @Id
    private String id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contact;
}

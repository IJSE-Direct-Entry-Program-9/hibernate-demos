package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@NamedNativeQuery(name = "findAllCustomers", query = "SELECT * FROM Customer")
@NamedNativeQuery(name = "findAllCustomers2", query = "SELECT * FROM Customer", resultClass = Customer.class)
@NamedNativeQuery(name = "findCustomer", query = "SELECT * FROM Customer WHERE id=?1")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
}

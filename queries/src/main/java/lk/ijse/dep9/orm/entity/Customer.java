package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@NamedQuery(name = "getContacts", query = "SELECT con FROM Customer c INNER JOIN Contact con ON con.pk.customer = c WHERE c.id=?1")
@NamedQuery(name = "getCustomerDetails", query = "SELECT c FROM Customer c WHERE c.id = ?1")
@NamedQuery(name = "getAllCustomers", query="SELECT c FROM Customer c")
@NamedNativeQuery(name = "findAllCustomers", query = "SELECT * FROM Customer")
@NamedNativeQuery(name = "findAllCustomers2", query = "SELECT * FROM Customer", resultClass = Customer.class)
@NamedNativeQuery(name = "findCustomer", query = "SELECT * FROM Customer WHERE id=?1", resultClass = Customer.class)
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

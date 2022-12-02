package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = "orderSet")
@ToString(exclude = "orderSet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet = new HashSet<>();

    public Customer(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orderSet.add(order);
    }

    public void setOrderSet(Set<Order> orderSet) {
        if (orderSet != null) orderSet.forEach(order -> order.setCustomer(this));
        this.orderSet = orderSet;
    }
}

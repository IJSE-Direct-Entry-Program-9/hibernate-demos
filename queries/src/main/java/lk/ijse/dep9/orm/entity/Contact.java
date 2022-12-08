package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@NamedQuery(name = "getContacts", query = "SELECT c FROM Contact c WHERE c.pk = ?")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact implements Serializable {
    @EmbeddedId
    private PK pk;

    public Contact(Customer customer, String contactNumber) {
        this(new PK(customer, contactNumber));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class PK implements Serializable {
        @ManyToOne
        @JoinColumn(name = "customer_id", referencedColumnName = "id")
        private Customer customer;
        @Column(name = "contact_number")
        private String contactNumber;
    }
}

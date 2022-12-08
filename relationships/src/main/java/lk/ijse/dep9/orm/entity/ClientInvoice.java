package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientInvoice implements Serializable {
    @EmbeddedId
    private ClientInvoicePK pk;
    private String username;

    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    @Setter(AccessLevel.NONE)
    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Invoice invoice;

    public ClientInvoice(String clientId, String invoiceId, String username) {
        this(new ClientInvoicePK(clientId, invoiceId), username);   // Calling (pk, username)
    }

    public ClientInvoice(ClientInvoicePK pk, String username) {
        this.pk = pk;
        this.username = username;
    }
}

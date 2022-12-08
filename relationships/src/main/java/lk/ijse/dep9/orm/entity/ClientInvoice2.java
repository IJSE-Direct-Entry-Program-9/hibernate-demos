package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ClientInvoicePK.class)
public class ClientInvoice2 implements Serializable {
    @Id
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    @Id
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @OneToOne
    private Invoice invoice;
    @Column(nullable = false)
    private String username;

//    public ClientInvoice2(ClientInvoicePK pk, String username) {
//        this.client.setId(pk.getClientId());
//        this.invoice.setId(pk.getInvoiceId());
//        this.username = username;
//    }

    public ClientInvoicePK getClientInvoicePK(){
        return new ClientInvoicePK(client.getId(), client.getId());
    }

//    public void setClientInvoicePK(ClientInvoicePK pk){
//        this.client.setId(pk.getClientId());
//        this.invoice.setId(pk.getInvoiceId());
//    }
}

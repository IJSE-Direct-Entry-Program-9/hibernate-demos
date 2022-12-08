package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ClientInvoicePK implements Serializable {
    //@Column(name = "client_id")
    private String client;
    //@Column(name = "invoice_id", unique=true)
    private String invoice;
}

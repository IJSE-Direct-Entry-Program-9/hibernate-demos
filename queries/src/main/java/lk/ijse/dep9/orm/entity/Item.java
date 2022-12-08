package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NamedNativeQuery(name = "item-query1", query= "SElECT * FROM Item WHERE qty >= 10",
        resultClass = Item.class)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    @Id
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int qty;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
}

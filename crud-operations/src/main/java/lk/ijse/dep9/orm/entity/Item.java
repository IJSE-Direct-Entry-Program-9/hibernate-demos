package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

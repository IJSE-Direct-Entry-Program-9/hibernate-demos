package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail implements Serializable {
    @EmbeddedId
    private PK pk;
    @Column(nullable = false)
    private int qty;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    public OrderDetail(Order order, Item item, int qty, BigDecimal unitPrice) {
        this(new PK(order, item), qty, unitPrice);
//        this.pk = new PK(order, item);
//        this.qty = qty;
//        this.unitPrice = unitPrice;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class PK implements Serializable {
        @ManyToOne
        @JoinColumn(name = "order_id", referencedColumnName = "id")
        private Order order;
        @ManyToOne
        @JoinColumn(name = "item_code", referencedColumnName = "code")
        private Item item;
    }
}

package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Invoice implements Serializable {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;
}

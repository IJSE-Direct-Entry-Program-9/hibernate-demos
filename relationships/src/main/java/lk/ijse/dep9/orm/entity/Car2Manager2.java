package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car2Manager2 implements Serializable {
    @EmbeddedId
    private Car2Manager2PK pk;
    @Column(nullable = false)
    private Date date;

    @Setter(AccessLevel.NONE)
    @OneToOne
    @JoinColumn(name = "m_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Manager2 manager2;

    @Setter(AccessLevel.NONE)
    @OneToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "registration_number", insertable = false, updatable = false)
    private Car2 car2;

    public Car2Manager2(int managerId, String registrationNumber, Date date) {
        this.pk = new Car2Manager2PK(managerId, registrationNumber);
        this.date = date;
    }

    public Car2Manager2(Car2Manager2PK pk, Date date) {
        this.pk = pk;
        this.date = date;
    }
}

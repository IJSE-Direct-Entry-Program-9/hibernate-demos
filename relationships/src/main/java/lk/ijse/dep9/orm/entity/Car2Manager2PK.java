package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Car2Manager2PK implements Serializable {
    @Column(name ="m_id", unique = true)
    private int managerId;
    @Column(name ="reg_no", unique = true)
    private String registrationNumber;
}

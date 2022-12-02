package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kid implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "guardian_nic", referencedColumnName = "nic", nullable = false)
    private Guradian guradian;
}

package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode(exclude = "kidSet")
@ToString(exclude = "kidSet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guradian implements Serializable {
    @Id
    private String nic;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @OneToMany(mappedBy = "guradian")
    private Set<Kid> kidSet = new HashSet<>();

    public Guradian(String nic, String name, String contact) {
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }

    public void addKid(Kid kid){
        if (kid == null) return;
        kid.setGuradian(this);
        kidSet.add(kid);
    }

    public void setKidSet(Set<Kid> kidSet) {
        if (kidSet != null)
        kidSet.forEach(kid -> {
            if (kid != null) kid.setGuradian(this);
        });
        this.kidSet = kidSet;
    }
}

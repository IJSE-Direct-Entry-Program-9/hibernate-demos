package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString(exclude = "mobile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @OneToOne(mappedBy = "student")
    private Mobile mobile;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setMobile(Mobile mobile) {
        mobile.setStudent(this);
        this.mobile = mobile;
    }
}

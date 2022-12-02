package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;

    @ManyToOne
    @JoinTable(name = "DepartmentMember",
        joinColumns = @JoinColumn(name = "m_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id"))
    private Department department;

    public Member(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}

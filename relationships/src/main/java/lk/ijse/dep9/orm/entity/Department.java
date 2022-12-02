package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"memberSet"})
@EqualsAndHashCode(exclude = "memberSet")
public class Department implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Member> memberSet = new HashSet<>();

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setMemberSet(Set<Member> memberSet) {
        if (memberSet != null) {
            memberSet.forEach(member -> {
                if (member == null) return;
                member.setDepartment(this);
            });
        }
        this.memberSet = memberSet;
    }

    public void addMember(Member member){
        if (member == null) return;
        member.setDepartment(this);
        memberSet.add(member);
    }

    public void removeMember(Member member){
        if (member == null || member.getDepartment() != this) return;
        member.setDepartment(null);
        memberSet.remove(member);
    }
}

package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Picture implements Serializable {
    @OneToOne
    @Id
    @JoinColumn(name="username", referencedColumnName = "username")
    //@PrimaryKeyJoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    @Column(name = "profile_picture", columnDefinition = "MEDIUMBLOB", nullable = false)
    private byte[] profilePicture;
}

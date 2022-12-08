package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
//    @ManyToMany
//    @JoinTable(name = "MovieActor",
//            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
//    private Set<Actor> actorSet = new HashSet<>();
//
//    public Movie(String id, String name, Date releaseDate) {
//        this.id = id;
//        this.name = name;
//        this.releaseDate = releaseDate;
//    }
}

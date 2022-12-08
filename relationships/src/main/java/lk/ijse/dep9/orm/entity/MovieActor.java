package lk.ijse.dep9.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActor implements Serializable {
    @EmbeddedId
    private MovieActorPK pk;
    @Column(name = "joined_date", nullable = false)
    private Date joinedDate;

    public MovieActor(Actor actor, Movie movie, Date joinedDate) {
        this(new MovieActorPK(actor, movie), joinedDate);
    }
}

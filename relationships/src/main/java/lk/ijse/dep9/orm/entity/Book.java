package lk.ijse.dep9.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('PUBLISHED', 'NOT_PUBLISHED')")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    public enum Status{
        PUBLISHED, NOT_PUBLISHED
    }
}

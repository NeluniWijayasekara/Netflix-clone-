
package com.example.Netflix.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Recommendation")
@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "movie_or_tvShow",nullable = false)
    private String movie_or_tvShow;

    @Column(name = "score",nullable = false)
    private double score;

}


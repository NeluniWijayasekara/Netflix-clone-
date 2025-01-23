package com.example.Netflix.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="Movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "releaseDate",nullable = false)
    private String releaseDate;

    @Column(name = "rating",nullable = false)
    private String rating;
}


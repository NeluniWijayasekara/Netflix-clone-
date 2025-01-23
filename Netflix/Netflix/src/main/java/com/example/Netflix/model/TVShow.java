package com.example.Netflix.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TVShow")
@Entity
public class TVShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = true)
    private String description;
    @Column(name = "rating",nullable = false)
    private String rating;


}

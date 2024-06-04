package com.maa.as5.as5.entity;

import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

    @ManyToOne
    private User author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    @BatchSize(size = 5)
    private List<Comment> comments;
    
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.spring.blog_application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "commenter_id")
    private User commenter;
}

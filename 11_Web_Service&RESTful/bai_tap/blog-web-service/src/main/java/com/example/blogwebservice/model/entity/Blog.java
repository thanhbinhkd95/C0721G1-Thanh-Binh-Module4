package com.example.blogwebservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;
    private String name;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer idBlog, String name, String content, Category category) {
        this.idBlog = idBlog;
        this.name = name;
        this.content = content;
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

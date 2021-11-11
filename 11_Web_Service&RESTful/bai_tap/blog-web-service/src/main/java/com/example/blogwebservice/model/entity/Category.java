package com.example.blogwebservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer idCategory;
    private String typeCategory;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Blog> blogList;

    public Category() {
    }

    public Category(Integer idCategory, String typeCategory, List<Blog> blogList) {
        this.idCategory = idCategory;
        this.typeCategory = typeCategory;
        this.blogList = blogList;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}

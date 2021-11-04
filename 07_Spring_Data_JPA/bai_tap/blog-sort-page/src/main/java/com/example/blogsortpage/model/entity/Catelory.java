package com.example.blogsortpage.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catelory")
public class Catelory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCatelory;
    private String typeCatelory;
    @OneToMany(mappedBy = "cateloryBlog")
    private List<Blog> blogList;

    public Catelory() {
    }

    public Integer getIdCatelory() {
        return idCatelory;
    }

    public void setIdCatelory(Integer idCatelory) {
        this.idCatelory = idCatelory;
    }

    public String getTypeCatelory() {
        return typeCatelory;
    }

    public void setTypeCatelory(String typeCatelory) {
        this.typeCatelory = typeCatelory;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}

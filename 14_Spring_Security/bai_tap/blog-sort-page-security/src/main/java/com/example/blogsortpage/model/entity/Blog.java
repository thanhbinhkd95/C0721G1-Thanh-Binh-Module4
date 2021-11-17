package com.example.blogsortpage.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String name;
    private String content;
    private Date dateBlog = new Date(System.currentTimeMillis());
    @ManyToOne
    @JoinColumn(name = "catelory_id", referencedColumnName = "idCatelory")
    private Catelory cateloryBlog;

    public Blog() {
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

    public Date getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(Date dateBlog) {
        this.dateBlog = dateBlog;
    }

    public Catelory getCateloryBlog() {
        return cateloryBlog;
    }

    public void setCateloryBlog(Catelory cateloryBlog) {
        this.cateloryBlog = cateloryBlog;
    }
}

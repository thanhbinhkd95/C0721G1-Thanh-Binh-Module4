package com.example.blogwebservice.controller;

import com.example.blogwebservice.model.entity.Blog;
import com.example.blogwebservice.model.entity.Category;
import com.example.blogwebservice.model.service.IBlogService;
import com.example.blogwebservice.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;


    //Xem danh sách blog
    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> findAllList(){
        List<Blog> blogList = this.blogService.findAll();
        System.err.print(blogList);
        if(blogList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    //Xem danh sách các bài viết của 1 category
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findByIdCategory(@PathVariable int id){
        Category category = this.categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogList(),HttpStatus.OK);
    }

    //Xem chi tiết 1 blog
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlog(@PathVariable int id){
        Blog blog = this.blogService.findById(id);
        if( blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    /*Xem danh sách các category*/
    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> category = this.categoryService.finAll();
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

//phân trang bằng web service
    //page: số trang hiện tại
    // size: số record trả về
    //PageRequest.of() trả về 1 đối tượng Pageable
    //Bản chất PageRequest.of chính là Pagable, với tham số đơn giản hơn.
    @GetMapping("/blog/getPage")
    public ResponseEntity<Page<Blog>> getPage( @RequestParam int page,int size) {
        Page<Blog> blogList = iBlogService.findAll(PageRequest.of(page,size));
        return   new ResponseEntity<>(blogList, HttpStatus.OK);
    }



    //tìm kiếm bằng web service
    @GetMapping("/blog/search/{idCategory}/{title}/{page}/{size}")
    public ResponseEntity<Page<Blog>> search(@PathVariable("idCategory") String id,
                                             @PathVariable("title") String title,
                                             @PathVariable("page") int page,
                                             @PathVariable("size") int size){
        Page<Blog> blogList = iBlogService.findAll(PageRequest.of(page,size),title,id);
        if (blogList.getSize()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return   new ResponseEntity<>(blogList, HttpStatus.OK);

    }
}

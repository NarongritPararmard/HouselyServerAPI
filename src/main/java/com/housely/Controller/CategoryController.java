package com.housely.Controller;

import com.housely.Model.Category.Category;
import com.housely.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public @ResponseBody List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public @ResponseBody Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public @ResponseBody Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setCategoryId(id);
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
            return ResponseEntity.ok(String.format("Category Id:%d was deleted successfully!", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("Category Id:%d not found!", id));
        }
    }

}

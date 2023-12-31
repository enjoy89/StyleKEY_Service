package com.thekey.stylekey.backend.controller.admin;

import com.thekey.stylekey.backend.model.category.entity.Category;
import com.thekey.stylekey.backend.model.item.entity.Item;
import com.thekey.stylekey.backend.service.admin.CategoryAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminCategoryController {

    private final CategoryAdminService categoryAdminService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryAdminService.findAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable Long id) {
        Category category = categoryAdminService.findById(id);

        if (isNull(category)) {
            return ResponseEntity.notFound().build();
        }

        List<Item> items = categoryAdminService.getItemsByCategoryId(id);
        Map<String, Object> response = Map.of(
                "category", category,
                "item", items
        );

        return ResponseEntity.ok(response);
    }

    private boolean isNull(Category category) {
        return category == null;
    }
}

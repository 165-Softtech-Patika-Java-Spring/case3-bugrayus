package com.case3bugrayus.controller;

import com.case3bugrayus.model.request.CreateProductRequestModel;
import com.case3bugrayus.model.request.UpdateProductRequestModel;
import com.case3bugrayus.model.response.ProductResponseModel;
import com.case3bugrayus.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ProductResponseModel getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public boolean createProduct(@RequestBody CreateProductRequestModel requestModel) {
        return productService.createProduct(requestModel);
    }

    @GetMapping("/products")
    public List<ProductResponseModel> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/product")
    public boolean updateProduct(@RequestBody UpdateProductRequestModel requestModel) {
        return productService.updateProduct(requestModel);
    }

    @DeleteMapping("/product/{id}")
    public boolean deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}

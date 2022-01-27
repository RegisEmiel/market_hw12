package com.geekbrains.market.controllers;

import com.geekbrains.market.entites.Product;
import com.geekbrains.market.entites.ProductImage;
import com.geekbrains.market.services.CategoryService;
import com.geekbrains.market.services.ImageSaverService;
import com.geekbrains.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    private  ImageSaverService imageSaverService;

    @Autowired
    public void setImageSaverService(ImageSaverService imageSaverService) {
        this.imageSaverService = imageSaverService;
    }

    @RequestMapping("/")
    public String showHomePage(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @GetMapping("/add")
    public String addNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "add-product";
    }

    @PostMapping("/add")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult theBindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String pathToSavedImage = imageSaverService.saveFile(file);
            ProductImage productImage = new ProductImage();
            productImage.setPath(pathToSavedImage);
            productImage.setProduct(product);
            product.addImage(productImage);
        }

        productService.saveProduct(product);

        return "redirect:/";
    }
}

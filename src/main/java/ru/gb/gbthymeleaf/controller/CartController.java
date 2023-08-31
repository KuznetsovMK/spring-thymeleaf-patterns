package ru.gb.gbthymeleaf.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.service.CartService;
import ru.gb.gbthymeleaf.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping()
    public String getProductList(Model model) {
        model.addAttribute("products", cartService.findAll());
        return "cart";
    }

    @GetMapping("/add")
    public String saveCart(@RequestParam(name = "id") Long id) {
        Product product = productService.findById(id);
        cartService.save(product);
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        cartService.deleteById(id);
        return "redirect:/cart";
    }
}

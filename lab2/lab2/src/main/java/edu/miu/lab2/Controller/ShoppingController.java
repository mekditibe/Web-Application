package edu.miu.lab2.Controller;

import edu.miu.lab2.Entity.Cart;
import edu.miu.lab2.Entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
public class ShoppingController {


    @GetMapping("/addproductpage")
    public ModelAndView productForm(@ModelAttribute("product") Product product){
        Map<String, Product> params = new HashMap<>();
        if(product == null){
            params.put("product", new Product());
        }
        params.put("product", product);
        return new ModelAndView("AddProduct",params);
    }


    @PostMapping("/add")
    public ModelAndView addProduct(HttpSession session, @ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        Map<String, Object> params = new HashMap<>();
        if (bindingResult.hasErrors()) {
            System.out.println("there is error");
        }
        if (product != null) {

            Map<String, Product> ProductList =
                    (Map<String, Product>) session.getAttribute("productSession");

            if (ProductList == null) {
                ProductList = new HashMap<>();
                session.setAttribute("productSession", ProductList);
            }

            ProductList.put(product.getPrNumber(), product);
            params.put("productList", ProductList.values());
        }
        return new ModelAndView("ListProduct", params);
    }

    @PostMapping("/removeproduct")
    public ModelAndView removeProduct(@RequestParam("prNumber") String prNumber, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        if (prNumber != null) {

            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productSession");

            if (productList == null) {
                productList = new HashMap<>();
                session.setAttribute("productSession", productList);
            }
            productList.remove(prNumber);
            params.put("productList", productList.values());
        }
        return new ModelAndView("ListProduct", params);
    }

    @PostMapping("/addcart")
    public ModelAndView addCart(@RequestParam("prNumber") String prNumber, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Cart cart = new Cart();
        double sumTotal=0;
        if (prNumber != null) {
            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productSession");
            Map<String, Cart> cartList = (Map<String, Cart>) session.getAttribute("cartSession");
            if (productList == null) {
                productList = new HashMap<>();
                session.setAttribute("productSession", productList);
            }

            for (Product product : productList.values()) {
                if (prNumber.equals(product.getPrNumber())) {
                    if (cartList != null && cartList.values().stream().findFirst().get().getProduct().getPrNumber().equals(prNumber)) {
                        int quantity = cartList.values()
                                .stream()
                                .findFirst()
                                .get()
                                .getQuantity() + 1;
                        cart.setQuantity(quantity);
                        cart.setProduct(product);
                        cart.setTotal(product.getPrice() * quantity);
                        cartList.put(prNumber, cart);
                        params.put("cartList", cartList.values());
                        return new ModelAndView("Cart", params);
                    }
                    cart.setQuantity(1);
                    cart.setProduct(product);
                    cart.setTotal(product.getPrice());
                }
                if (cartList == null) {
                    cartList = new HashMap<>();
                    session.setAttribute("cartSession", cartList);
                }
                sumTotal+=cart.getTotal();
            }
            cartList.put(prNumber, cart);
            params.put("cartList", cartList.values());
            params.put("sumTotal", sumTotal);

        }
        return new ModelAndView("Cart", params);
    }

    @PostMapping("/removecart")
    public ModelAndView removeCart(@RequestParam("prNumber") String prNumber, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Cart> cartList = (Map<String, Cart>) session.getAttribute("cartSession");
        for (Cart list : cartList.values()) {
            if (list.getQuantity() >= 2 && (list.getProduct().getPrNumber().equals(prNumber))) {
                Cart copyCart = new Cart();
                copyCart.setProduct(list.getProduct());
                copyCart.setTotal((list.getQuantity() - 1) * list.getProduct().getPrice());
                copyCart.setQuantity(list.getQuantity() - 1);
                cartList.put(prNumber, copyCart);
                params.put("cartList", cartList.values());
                return new ModelAndView("Cart", params);
            }else{
                cartList.remove(prNumber);
            }
            params.put("cartList", cartList.values());
        }
        return new ModelAndView("Cart", params);
    }
    @GetMapping("/products")
    public ModelAndView init(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Product> ProductList =
                (Map<String, Product>) session.getAttribute("productSession");
        if (ProductList == null) {
            ProductList = new HashMap<>();
        }
        params.put("productList", ProductList.values());
        return new ModelAndView("ListProduct", params);
    }
}

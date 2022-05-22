package com.example.demo.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.exception;



import org.springframework.ui.Model;

//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.Product;

import com.example.demo.dto.ProductDTO;

import com.example.demo.model.Category;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.CategoryDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Controller
public class MainController {
	
	@Autowired
	ProductDao ProductDAO;
	
	 @Autowired
	 CategoryDAO categoryService;
	
	@RequestMapping("/welcome")
	public ModelAndView home() {
		System.out.println("R u here");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AdminPage");
		return mav;
	}
	
	@GetMapping("/welcome/showproductadmin/addproduct")
	public String addproductget2(ModelMap model, Product product) throws exception {
	
		model.addAttribute("product", product);		
		model.addAttribute("categories", categoryService.findAll());
		return "addproduct";
	}

	@PostMapping("/welcome/showproductadmin/addproduct")
	public String productAddPost(@ModelAttribute("product")ProductDTO productd,ProductDao productdao,HttpServletRequest request ) throws IOException, exception {
		System.out.println("R u coming here");
		
        Product product = new Product();
        int categoryId = Integer.parseInt(request.getParameter("category"));
        product.setProduct_id(productd.getProduct_id());
        product.setBookName(productd.getBookName());
        product.setCategory(categoryService.getCategoryById(categoryId));
        product.setPrice(productd.getPrice());  		
        System.out.println(product+"r u coming here");	
        System.out.println(categoryId);  
        productdao.addcreate(product);
        return "redirect:/welcome/showproductadmin";
    }
	
	
	@GetMapping("/welcome/showproductadmin")
	public String getproduct(ProductDao productdao, Model model) throws exception {
		List<Product>  pdlist  =  ProductDAO.list();
	
		model.addAttribute("Data1", pdlist);
		model.addAttribute("category", categoryService.findAll());
		return "showproductadmin";
	}
	
    @GetMapping("/welcome/showproductadmin/delete/{product_uid}")

        public String removeProduct(@PathVariable("product_uid") int product_uid,HttpServletRequest request){
    	 System.out.println(product_uid+ " before deleting, were u here");
    	 ProductDAO.deleteById(product_uid);
    	 System.out.println(product_uid+ " product was removed or not");

    	 return "redirect:/welcome/showproductadmin";
    }

   
    @GetMapping("/welcome/showproductadmin/update/{product_uid}")
    public String updateproduct(@PathVariable("product_uid") int product_uid,Model model,HttpServletRequest request) throws exception {

		Product newProduct = ProductDAO.getProductById(product_uid);
		if(newProduct!=null)
		{
			model.addAttribute("product", newProduct);
			return "editProduct";
		}

	return "redirect:/welcome/showproductadmin";    		
    }
   	

    @PostMapping("/welcome/showproductadmin/update/{product_uid}")
    public String updatepPost(@ModelAttribute("product") Product product, BindingResult result,Model model, 
			SessionStatus status, ProductDao productdao) throws exception {

    	System.out.println(product+"r u coming here");	
		productdao.save(product);
		int id= product.getProduct_uid();
		model.addAttribute("product", product);
		model.addAttribute("category", categoryService.findById(id));
		return "redirect:/welcome/showproductadmin";
	}

    @GetMapping("/welcome/categories")
    public String getCategory(Model model) throws exception{

        List<Category>  pdlist  =  categoryService.findAll();
    	
		model.addAttribute("categories", pdlist);
		return "categories";
    }

    //Add Categories 
    @GetMapping("/welcome/categories/add")
    public String getCategoryAdd(Model model, Category category) throws exception{
        model.addAttribute("product1", category);
        
        return "categoriesAdd";
        
    }

    //Add Categories 
    @PostMapping("/welcome/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category,SessionStatus status){

    	
    	status.setComplete();
        categoryService.save(category);
      
        return "redirect:/welcome/categories";
    }


    @GetMapping("/welcome/categories/update/{id}")
    public String updateCategory(@PathVariable("id") int id,Model model,HttpServletRequest request) throws exception {

    		Category category = categoryService.findById(id);
    		model.addAttribute("product2", category);


    		return "editCategory";  	
    }
    @PostMapping("/welcome/categories/update/{id}")
    public String updatepCategory(@ModelAttribute("product2") Category category, BindingResult result,Model model, 
			SessionStatus status, CategoryDAO categoryService) throws exception {

    	System.out.println(category+"r u coming here");	
    	categoryService.update(category);
		model.addAttribute("product2", category);
		return "redirect:/welcome/categories";
	}

    //Delete Categories 
    @GetMapping("/welcome/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
    
       	 System.out.println(id+ " before deleting, were u here");
       	 categoryService.deleteById(id);
       	 System.out.println(id+ " product was removed or not");

       	 return "redirect:/welcome/categories";
    }
    
	 
		@RequestMapping("/aboutus")
		public String sayAboutus() {
			return "aboutUs";
		}		
	}




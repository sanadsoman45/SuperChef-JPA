//package com.demo.superchef.SuperChefJPA.Controllers;
//
//import com.demo.superchef.SuperChefJPA.Entities.Ingredients;
//import com.demo.superchef.SuperChefJPA.Service.IngredientServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/superchef")
//public class IngredientsController {
//
//    @Autowired
//    IngredientServiceImpl ingService;
//
//    @PostMapping("/ingredients/{emailid}")
//    public Ingredients insertIng(@RequestBody Ingredients ing){
//        return ingService.insertIng(ing);
//    }
//
//    @GetMapping("/ingredients/getalling/{emailid}")
//    public Set<Ingredients> getAllIng(@PathVariable String emailid){
//        return ingService.getAllIng(emailid);
//    }
//
//    @GetMapping("/ingredients/{emailid}/geting/{ingname}")
//    public Set<Ingredients> getIng(@PathVariable String ingname,@PathVariable String emailid){
//        return ingService.getIng(ingname,emailid);
//    }
//
//    @GetMapping("/ingredients/{emailid}/getcategory/{ingcategory}")
//    public Set<Ingredients> getIngByCategory(@PathVariable String emailid, @PathVariable String ingcategory){
//        return ingService.getIngByCategory(emailid,ingcategory);
//    }
//
//    @GetMapping("/ingredients/count/{emailid}")
//    public int getIngCount(@PathVariable String emailid){
//        return ingService.getIngCount(emailid);
//    }
//
//    @DeleteMapping("/ingredients/{emailid}/ingredient/{ingname}")
//    public void deleteIng(@PathVariable String emailid, String ingname){
//        ingService.deleteIng(emailid,ingname);
//    }
//
//    @DeleteMapping("/ingredients/{emailid}")
//    public void deleteIng(@PathVariable String emailid){
//        ingService.deleteIng(emailid);
//    }
//
//}

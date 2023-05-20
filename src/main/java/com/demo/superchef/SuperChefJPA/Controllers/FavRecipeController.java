package com.demo.superchef.SuperChefJPA.Controllers;

import com.demo.superchef.SuperChefJPA.Entities.FavRecipes;
import com.demo.superchef.SuperChefJPA.Entities.User;
import com.demo.superchef.SuperChefJPA.Service.FavRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/superchef")
public class FavRecipeController {

    @Autowired
    FavRecipesService favRecipeService;

    @PutMapping("/{emailid}/recipe/{recipename}")
    public User assignFavRecipe(@PathVariable String emailid, @PathVariable String recipename){
        return favRecipeService.saveFavRecipes(emailid,recipename);
    }

    @GetMapping("/user/{emailid}")
    public Set<FavRecipes> getFavouriteRecipes(@PathVariable String emailid){
        return favRecipeService.getfavRecipes(emailid);
    }

    @GetMapping("/user/{emailid}/recipe/{recipename}")
    public Set<FavRecipes> getRecipesByName(@PathVariable String emailid,@PathVariable String recipename){
        return favRecipeService.getRecipesByName(emailid,recipename);
    }

    @GetMapping("/user/{emailid}/recipeing/{recipeing}")
    public Set<FavRecipes> getRecipesByIng(@PathVariable String emailid, @PathVariable String recipeing){
        return favRecipeService.getRecipesByIngName(emailid, recipeing);
    }

    @GetMapping("/recipecount/{emailid}")
    public String getRecipeCount(@PathVariable String emailid){
        return favRecipeService.getRecipeCount(emailid);
    }

    @GetMapping("/recipes/getall")
    public List<FavRecipes> getAllFavRecipes(){
        return favRecipeService.getAllFavRecipes();
    }

    @DeleteMapping("/recipes/{recipename}/user/{emailid}")
    public void deleteRecipeByName(@PathVariable String recipename, @PathVariable String emailid){
        favRecipeService.deleteRecipeByName(recipename,emailid);
    }

    @DeleteMapping("/recipe/{emailid}")
    public void deleteRecipeByEmail(@PathVariable String emailid){
        favRecipeService.deleteRecipeByEmailid(emailid);
    }




}

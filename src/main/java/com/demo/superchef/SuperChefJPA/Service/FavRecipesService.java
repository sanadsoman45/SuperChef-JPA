package com.demo.superchef.SuperChefJPA.Service;

import com.demo.superchef.SuperChefJPA.Entities.FavRecipes;
import com.demo.superchef.SuperChefJPA.Entities.User;

import java.util.List;
import java.util.Set;

public interface FavRecipesService {

    Set<FavRecipes> getfavRecipes(String emailid);

    User saveFavRecipes(String emailId, String recipeName);

    Set<FavRecipes> getRecipesByName(String emailid, String recipename);

    Set<FavRecipes> getRecipesByIngName(String emailid, String recipeing);

    String getRecipeCount(String emailid);

    void deleteRecipeByName(String emailid,String recipename);

    void deleteRecipeByEmailid(String emailid);

    List<FavRecipes> getAllFavRecipes();

}

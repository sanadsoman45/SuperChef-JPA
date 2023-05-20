package com.demo.superchef.SuperChefJPA.Service;

import com.demo.superchef.SuperChefJPA.Dao.FavRecipesDao;
import com.demo.superchef.SuperChefJPA.Dao.RecipeDao;
import com.demo.superchef.SuperChefJPA.Dao.UserDao;
import com.demo.superchef.SuperChefJPA.Entities.FavRecipes;
import com.demo.superchef.SuperChefJPA.Entities.Recipes;
import com.demo.superchef.SuperChefJPA.Entities.User;
import com.demo.superchef.SuperChefJPA.Exceptions.RecipeNotFound;
import com.demo.superchef.SuperChefJPA.Exceptions.recipeAlreadyexists;
import com.demo.superchef.SuperChefJPA.Exceptions.userNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FavRecipesServiceImpl implements  FavRecipesService{

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private FavRecipes favRecipes;

    @Autowired
    private UserDao userDao;

    @Autowired
    private FavRecipesDao favRecipeDao;


    public User saveFavRecipes(String emailId,String recipeName){
        Set<FavRecipes> favRecipeSet = null;
        Recipes recipe = recipeDao.findByrecipeName(recipeName);
        Optional<User> result = userDao.findById(emailId);
        User user = null;
        if(result.isPresent()){
            for(FavRecipes recipes : result.get().getFavRecipes()){
                if(recipes.getFavrecipeName().equalsIgnoreCase(recipeName)){
                    throw new recipeAlreadyexists("User is already associated to the receipe");
                }
            }
            if(recipe!=null){
                //todo
            }
        }
        if(result.isPresent() && recipe != null){
            user = result.get();
            System.out.println("user does not has recipe");
            favRecipes.setFavrecipeName(recipe.getRecipeName());
            favRecipes.setFavimageUrl(recipe.getImageUrl());
            favRecipes.setFavrecipeIng(recipe.getRecipeIng());
            favRecipes.setFavrecipeInstr(recipe.getImageUrl());
            favRecipes.setFavcookTime(recipe.getCook_time());
            favRecipes.setFavprepTime(recipe.getPrepTime());
            favRecipes.setFavtotalTime(recipe.getTotal_time());
            favRecipeSet = user.getFavRecipes();
            favRecipeSet.add(favRecipes);
            user.setFavRecipes(favRecipeSet);
            userDao.save(user);

        }

        else{
            if(!result.isPresent()) throw new userNotFound("User Details Not Found for: "+emailId);
            else if(recipe == null) throw new RecipeNotFound("Receipe does not exists");
            else try {
                    throw new Exception();
                } catch (Exception e) {
                    e.getCause().getMessage();
                }
        }

        return userDao.save(user);

    }

    @Override
    public Set<FavRecipes> getRecipesByName(String emailid,String recipename) {
        Optional<User> result = userDao.findById(emailid);
        Set<FavRecipes> recipeSet = new HashSet<>();
        if(result.isPresent()){
            for(FavRecipes recipe : result.get().getFavRecipes()){
                if(recipe.getFavrecipeName().equalsIgnoreCase(recipename)){
                    recipeSet.add(recipe);
                }
            }

            if(recipeSet.size() == 0){
                throw new RecipeNotFound("No Recipes Found With the Recipe Name provided "+recipename);
            }
        }
        else{
            throw new userNotFound("User Not Found For: "+emailid);
        }
        return recipeSet;
    }

    @Override
    public Set<FavRecipes> getRecipesByIngName(String emailid, String recipeing) {
        Optional<User> result = userDao.findById(emailid);
        Set<FavRecipes> recipeSet = new HashSet<>();
        if(result.isPresent()){
            for(FavRecipes recipe : result.get().getFavRecipes()){
                if(recipe.getFavrecipeIng().toLowerCase().contains(recipeing.toLowerCase())){
                    recipeSet.add(recipe);
                }
            }
            if(recipeSet.size() == 0){
                throw new RecipeNotFound("No Recipes Found With the ingredients provided "+recipeing);
            }

        }
        else{
            throw new userNotFound("User Not Found For: "+emailid);
        }
        return recipeSet;
    }

    @Override
    public String getRecipeCount(String emailid) {
        Optional<User> result = userDao.findById(emailid);
        if(!result.isPresent()){
            throw new userNotFound("User Details Not Found for: "+emailid);
        }
        return "Count of Recipes for "+emailid+" is: "+result.get().getFavRecipes().size();
    }

    public Set<FavRecipes> getfavRecipes(String emailid){
        Optional<User> result = userDao.findById(emailid);
        if(!result.isPresent()){
            throw new userNotFound("User Not Found For: "+emailid);
        }
        return result.get().getFavRecipes();
    }

    @Override
    public void deleteRecipeByName(String recipename, String emailid) {
//        Optional<User> user = userDao.findById(emailid);
//        if(user.isPresent()){
//            for(FavRecipes favRecipe: user.get().getFavRecipes()){
//                if(favRecipe.getFavrecipeName().equalsIgnoreCase(recipename)){
//                    System.out.println(favRecipe);
//                    favRecipeDao.delete(favRecipe);
//                    System.out.println(favRecipe);
//                }
//            }
//
//        }
//        else{
//            throw new userNotFound("User Not Found For: "+emailid);
//        }
        Optional<FavRecipes> favRecipes = Optional.ofNullable(favRecipeDao.findByfavrecipeName(recipename));
        Optional<User> user = userDao.findById(emailid);
        if(favRecipes.isPresent() && user.isPresent()){
            user.get().getFavRecipes().remove(favRecipes.get());
            favRecipeDao.deleteById(favRecipes.get().getFavrecipeId());
            user.get().getFavRecipes();
            System.out.println(user);
            userDao.save(user.get());
        }

        // user -> fav_recipe onetomany
        // fav_recipe -> user manytoone
        // recipe ->
        /*
        userinfo   fav_songinfo fav_song_userid /fav-recipe
        Bhushan    abc abc_123   bhush           X
        Bhushan    def def_123   bhush           #
        Sanad      abc abc_123   San
        Sanad      def def_123   San

        many to many
        many users have many fav songs
        many favsongs have many users X

        song_123
        song_456

        admin
        get all users and get their fav songs




         */

    }

    @Override
    public void deleteRecipeByEmailid(String emailid) {
        Optional<User> user = userDao.findById(emailid);
        if(user.isPresent()){
            for(FavRecipes favRecipe: user.get().getFavRecipes()){

                favRecipeDao.delete(favRecipe);
            }
        }
        else{
            throw new userNotFound("User Not Found For: "+emailid);
        }
    }



    public List<FavRecipes> getAllFavRecipes(){
        return favRecipeDao.findAll();
    }


}

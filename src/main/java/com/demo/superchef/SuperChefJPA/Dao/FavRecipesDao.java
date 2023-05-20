package com.demo.superchef.SuperChefJPA.Dao;

import com.demo.superchef.SuperChefJPA.Entities.FavRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavRecipesDao extends JpaRepository<FavRecipes,Integer> {
        FavRecipes findByfavrecipeName(String favrecipe_name);

}

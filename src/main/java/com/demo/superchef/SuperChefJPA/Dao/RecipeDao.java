package com.demo.superchef.SuperChefJPA.Dao;

import com.demo.superchef.SuperChefJPA.Entities.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDao extends JpaRepository<Recipes,Integer> {

    Recipes findByrecipeName(String recipename);

}

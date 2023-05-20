package com.demo.superchef.SuperChefJPA.Service;

import com.demo.superchef.SuperChefJPA.Entities.Ingredients;

import java.util.Set;

public interface IngredientService {

    Ingredients insertIng(Ingredients ing);

    Set<Ingredients> getAllIng(String emailid);

    Set<Ingredients> getIng(String ingname, String emailid);

    Set<Ingredients> getIngByCategory(String emailid, String ingcategory);

    int getIngCount(String emailid);

    void deleteIng(String emailid, String ingname);

    void deleteIng(String emailid);
}

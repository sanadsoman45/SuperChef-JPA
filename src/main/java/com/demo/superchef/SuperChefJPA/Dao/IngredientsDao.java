package com.demo.superchef.SuperChefJPA.Dao;

import com.demo.superchef.SuperChefJPA.Entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsDao extends JpaRepository<Ingredients,Integer> {

//    int countByEmailIdAndEmailId(String ingName, String emailId);

}

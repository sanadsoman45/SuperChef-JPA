//package com.demo.superchef.SuperChefJPA.Service;
//
//import com.demo.superchef.SuperChefJPA.Dao.IngredientsDao;
//import com.demo.superchef.SuperChefJPA.Dao.UserDao;
//import com.demo.superchef.SuperChefJPA.Entities.Ingredients;
//import com.demo.superchef.SuperChefJPA.Entities.User;
//import com.demo.superchef.SuperChefJPA.Exceptions.IngredientAlreadyExistsException;
//import com.demo.superchef.SuperChefJPA.Exceptions.IngredientNotFoundException;
//import com.demo.superchef.SuperChefJPA.Exceptions.userNotFound;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class IngredientServiceImpl implements IngredientService{
//
//    //declaring the reference variables
//    @Autowired
//    private IngredientsDao ingDao;
//
//    @Autowired
//    private Ingredients ing;
//
//    @Autowired
//    private UserDao userDao;
//
//    //adding ingredients selected by users.
//    public Ingredients insertIng(Ingredients ing){
//        Set<Ingredients> ingSet = null;
//        if(count >0){
//            throw new IngredientAlreadyExistsException("Ingredient Already Exists");
//        }
//        ing.
//        return ingDao.save(ing);
//    }
//
//    @Override
//    public Set<Ingredients> getAllIng(String emailid) {
//        Optional<User> result = userDao.findById(emailid);
//        if(!result.isPresent()){
//            throw new IngredientNotFoundException("No Ingredient Found.");
//        }
//        return result.get().getUserIngs();
//    }
//
//    @Override
//    public Set<Ingredients> getIng(String ingname, String emailid) {
//        Optional<User> result = userDao.findById(emailid);
//        Set<Ingredients> ingSet = null;
//        if(!result.isPresent()){
//            throw new userNotFound("User not Found for: "+emailid);
//        }
//        else{
//            ingSet = result.get().getUserIngs();
//            if(ingSet.isEmpty()){
//                throw new IngredientNotFoundException("Ingredient not found by the name: "+ingname);
//            }
//            else{
//                for(Ingredients ing: ingSet){
//                    if(!ing.getIngName().equalsIgnoreCase(ingname)){
//                        ingSet.remove(ing);
//                    }
//                }
//            }
//        }
//
//        return ingSet;
//    }
//
//    @Override
//    public Set<Ingredients> getIngByCategory(String emailid, String ingcategory) {
//
//        Optional<User> result = userDao.findById(emailid);
//        Set<Ingredients> ingSet = null;
//        if(!result.isPresent()){
//            throw new userNotFound("User not Found for: "+emailid);
//        }
//        else{
//            ingSet = result.get().getUserIngs();
//            if(ingSet.isEmpty()){
//                throw new IngredientNotFoundException("Ingredient not found for Category: "+ingcategory);
//            }
//            else{
//                for(Ingredients ing: ingSet){
//                    if(!ing.getIngName().equalsIgnoreCase(ingcategory)){
//                        ingSet.remove(ing);
//                    }
//                }
//            }
//        }
//
//        return ingSet;
//    }
//
//    @Override
//    public int getIngCount(String emailid) {
//        Optional<User> result = userDao.findById(emailid);
//        if(!result.isPresent()){
//            throw new userNotFound("User not Found for: "+emailid);
//        }
//        return result.get().getUserIngs().size();
//
//    }
//
//    @Override
//    public void deleteIng(String emailid, String ingname) {
//        Optional<User> result = userDao.findById(emailid);
//        Set<Ingredients> ingSet = null;
//        if(!result.isPresent()){
//            throw new userNotFound("User not Found for: "+emailid);
//        }
//        else{
//            ingSet = result.get().getUserIngs();
//            if(ingSet.isEmpty()){
//                throw new IngredientNotFoundException("Ingredients not found");
//            }
//            else{
//                for(Ingredients ing: ingSet){
//                    if(ing.getIngName().equalsIgnoreCase(ingname)){
//                        ingDao.delete(ing);
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public void deleteIng(String emailid) {
//        Optional<User> result = userDao.findById(emailid);
//        Set<Ingredients> ingSet = null;
//        if(!result.isPresent()){
//            throw new userNotFound("User not Found for: "+emailid);
//        }
//        else {
//            ingSet = result.get().getUserIngs();
//            if (ingSet.isEmpty()) {
//                throw new IngredientNotFoundException("Ingredients not found");
//            } else {
//                for(Ingredients ing: ingSet){
//                    ingDao.delete(ing);
//                }
//            }
//        }
//    }
//
//
//}

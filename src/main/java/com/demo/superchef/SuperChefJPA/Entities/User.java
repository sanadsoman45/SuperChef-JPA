package com.demo.superchef.SuperChefJPA.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    //Define the database Fields
    @Id
    @Column(name = "user_email",nullable = false, length=100)
    private String userEmail;

    @Column(name = "user_name",length = 100)
    private String userName;

    @Column(name = "user_passwd",length = 100)
    private String passwd;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "User_Fav_Recipes",
            joinColumns = @JoinColumn(name = "userEmail",referencedColumnName = "user_email"),
            //favrecipe_id, favcook_time, favimage_url, favprep_time, favrecipe_ing, favrecipe_instr, favrecipe_name, favtotal_time
            inverseJoinColumns = @JoinColumn(name = "Fav_recipesId",referencedColumnName = "favrecipeId")
    )
    private Set<FavRecipes> favRecipes = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    @JoinTable(name = "User_Ingredients",
            joinColumns = {@JoinColumn(name = "userEmail",referencedColumnName = "user_email")},
            inverseJoinColumns = {@JoinColumn(name = "ingId",referencedColumnName = "ingId")}
    )
    private Set<Ingredients> userIngs = new HashSet<>();

    //Define Getters and Setters


    public Set<Ingredients> getUserIngs() {
        return userIngs;
    }

    public void setUserIngs(Set<Ingredients> userIngs) {
        this.userIngs = userIngs;
    }

    public Set<FavRecipes> getFavRecipes() {
        return favRecipes;
    }

    public void setFavRecipes(Set<FavRecipes> favRecipes) {
        this.favRecipes = favRecipes;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}

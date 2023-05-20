package com.demo.superchef.SuperChefJPA.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import java.util.*;


@Entity
@Component
public class FavRecipes {

    //define the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favrecipeId", length = 100, nullable = false)
    private int favrecipeId;
    @Column(name = "favrecipeName", length = 200, nullable = false)
    private String favrecipeName;
    @Column(name = "favimageUrl", length = 65535, columnDefinition = "TEXT", nullable = false)
    @Type(type = "text")
    private String favimageUrl;
    @Column(name = "favrecipeIng", length = 65535, columnDefinition = "TEXT", nullable = false)
    @Type(type = "text")
    private String favrecipeIng;
    @Column(name = "favrecipeInstr", length = 65535, columnDefinition = "TEXT", nullable = false)
    @Type(type = "text")
    private String favrecipeInstr;
    @Column(name = "favcookTime", length = 100)
    private String favcookTime;
    @Column(name = "favprepTime", length = 100)
    private String favprepTime;
    @Column(name = "favtotalTime", length = 100)
    private String favtotalTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "favRecipes",cascade = CascadeType.REMOVE)
    private Set<User> users = new HashSet<>();

    //define the methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavRecipes that = (FavRecipes) o;
        return getFavrecipeId() == that.getFavrecipeId() && getFavrecipeName().equals(that.getFavrecipeName());
    }



    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getFavrecipeId() {
        return favrecipeId;
    }

    public void setFavrecipeId(int favrecipeId) {
        this.favrecipeId = favrecipeId;
    }


    public String getFavrecipeName() {
        return favrecipeName;
    }

    public void setFavrecipeName(String favrecipeName) {
        this.favrecipeName = favrecipeName;
    }

    public String getFavimageUrl() {
        return favimageUrl;
    }

    public void setFavimageUrl(String favimageUrl) {
        this.favimageUrl = favimageUrl;
    }

    public String getFavrecipeIng() {
        return favrecipeIng;
    }

    public void setFavrecipeIng(String favrecipeIng) {
        this.favrecipeIng = favrecipeIng;
    }

    public String getFavrecipeInstr() {
        return favrecipeInstr;
    }

    public void setFavrecipeInstr(String favrecipeInstr) {
        this.favrecipeInstr = favrecipeInstr;
    }

    public String getFavcookTime() {
        return favcookTime;
    }

    public void setFavcookTime(String favcookTime) {
        this.favcookTime = favcookTime;
    }

    public String getFavprepTime() {
        return favprepTime;
    }

    public void setFavprepTime(String favprepTime) {
        this.favprepTime = favprepTime;
    }

    public String getFavtotalTime() {
        return favtotalTime;
    }

    public void setFavtotalTime(String favtotalTime) {
        this.favtotalTime = favtotalTime;
    }

    @Override
    public String toString() {
        return "FavRecipes{" +
                "favrecipeId=" + favrecipeId +
                ", favrecipeName='" + favrecipeName + '\'' +
                ", favimageUrl='" + favimageUrl + '\'' +
                ", favrecipeIng='" + favrecipeIng + '\'' +
                ", favrecipeInstr='" + favrecipeInstr + '\'' +
                ", favcookTime='" + favcookTime + '\'' +
                ", favprepTime='" + favprepTime + '\'' +
                ", favtotalTime='" + favtotalTime + '\'' +
                ", users=" + users +
                '}';
    }
}

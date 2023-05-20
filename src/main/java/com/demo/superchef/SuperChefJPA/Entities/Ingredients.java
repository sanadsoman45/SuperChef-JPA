package com.demo.superchef.SuperChefJPA.Entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ingId;

    private String ingCategory;

    private String ingName;

    @ManyToMany(mappedBy = "userIngs",cascade = {CascadeType.MERGE})
    private Set<User> user = new HashSet<>();

    public Ingredients() {
    }

    public Ingredients(int ingId, String ingCategory,String ingName, Set<User> user) {
        this.ingId = ingId;
        this.ingCategory = ingCategory;

        this.ingName = ingName;
        this.user = user;
    }

    public int getIngId() {
        return ingId;
    }

    public void setIngId(int ingId) {
        this.ingId = ingId;
    }

    public String getIngCategory() {
        return ingCategory;
    }

    public void setIngCategory(String ingCategory) {
        this.ingCategory = ingCategory;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}

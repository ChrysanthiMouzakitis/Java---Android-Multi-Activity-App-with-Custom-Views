package com.example.customrecyclerlist;

import android.util.Log;

import java.io.Serializable;

import java.util.List;

public class Food implements Serializable {

    private String name, image, subtitle, description, url, ingredients, instruction;


    public Food(String name, String image, String subtitle, String description, String url, String ingredients, String instruction) {
        this.name = name;
        this.image = image;
        this.subtitle = subtitle;
        this.description = description;
        this.url = url;
        this.ingredients = ingredients;
        this.instruction = instruction;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle(){return subtitle;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients(){
        return ingredients;
    }

    public String getInstruction(){

        return instruction;
    }


}

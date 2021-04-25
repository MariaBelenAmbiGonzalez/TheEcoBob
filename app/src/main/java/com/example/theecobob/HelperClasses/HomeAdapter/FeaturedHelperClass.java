package com.example.theecobob.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    //Para las cards del RV

    //Variables
    int image;
    String tittle, description;

    public FeaturedHelperClass() {
    }

    public FeaturedHelperClass(int image, String tittle, String description) {
        this.image = image;
        this.tittle = tittle;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

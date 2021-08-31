package com.example.roadtrip;

import java.util.Map;

public class Cuisine {
    private String id;
    private String foodName;
    private String foodType;
    private String foodDescription;

    public Cuisine() {
    }

    public Cuisine(String id, String foodName, String foodType, String foodDescription){

        this.id = id;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodDescription = foodDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public static Cuisine fromMapToCuisine(Map<String, Object> map) {
        Cuisine c = null;
        if (map != null) {

            c = new Cuisine();

            if (map.containsKey("id")) c.setId(map.get("id").toString());
            if (map.containsKey("foodName")) c.setFoodName(map.get("foodName").toString());
            if (map.containsKey("foodType")) c.setFoodType(map.get("foodType").toString());
            if (map.containsKey("foodDescription")) c.setFoodDescription(map.get("foodDescription").toString());
        }
        return c;
    }

    @Override
    public String toString() {
        return "Cuisine{" +
                "id='" + id + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodDescription='" + foodDescription + '\'' +
                '}';
    }
}

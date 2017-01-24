package com.spoon.DeliciousCanteen.entity;


public class Food {
     private int id;
     private int foodPicture;
     private String name;
     private double price;
     private double score;
     private int isCheck;

     public double getScore() {
          return score;
     }

     public void setScore(double score) {
          this.score = score;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getFoodPicture() {
          return foodPicture;
     }

     public void setFoodPicture(int foodPicture) {
          this.foodPicture = foodPicture;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public int getIsCheck() {
          return isCheck;
     }

     public void setIsCheck(int isCheck) {
          this.isCheck = isCheck;
     }
}
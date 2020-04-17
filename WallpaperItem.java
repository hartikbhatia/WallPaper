package com.example.hp.wall.ModelPack;

public class WallpaperItem {

    public String categoryId,image;

    public WallpaperItem() {
    }

    public WallpaperItem(String categoryId, String image) {
        this.categoryId = categoryId;
        this.image = image;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package com.example.hp.wall;

public class Model {
    String image;
    String title;

    public Model(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public Model(){}
    public String getImage()
    {
        return this.image;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setImage(String image)
    {
        this.image=image;
    }

      public void setTitle(String title)
      {
          this.title=title;
      }

}

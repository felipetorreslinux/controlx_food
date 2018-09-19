package br.com.espe.controlxfood_aplicativo.Models;

public class SlidesIntro {
    int id;
    String info;
    int image;
    String title;
    String subtitle;

    public SlidesIntro(int id, String info, int image, String title, String subtitle) {
        this.id = id;
        this.info = info;
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}

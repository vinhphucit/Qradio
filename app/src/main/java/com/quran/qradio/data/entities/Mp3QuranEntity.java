package com.quran.qradio.data.entities;

/**
 * Created by PhucTV on 6/9/16.
 */
public class Mp3QuranEntity {
    private String file;
    private String title;
    private String image;

    public Mp3QuranEntity(String file, String title, String image) {
        this.file = file;
        this.title = title;
        this.image = image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

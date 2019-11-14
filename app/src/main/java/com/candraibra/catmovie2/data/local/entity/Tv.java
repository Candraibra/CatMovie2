/*
 * *
 *  * Created by Candra Ibra Sanie on 11/14/19 9:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/14/19 9:05 PM
 *
 */

package com.candraibra.catmovie2.data.local.entity;

public class Tv {
    private String tvId;
    private String title;
    private String desc;
    private int image;

    public Tv(String tvId, String title, String desc, int image) {
        this.tvId = tvId;
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTvId() {
        return tvId;
    }



    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }


    public int getImage() {
        return image;
    }

}

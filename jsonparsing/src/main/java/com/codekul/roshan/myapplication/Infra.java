
package com.codekul.roshan.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Infra {

    @SerializedName("furniture")
    @Expose
    private Boolean furniture;
    @SerializedName("ac")
    @Expose
    private Boolean ac;
    @SerializedName("popularity")
    @Expose
    private Integer popularity;

    public Boolean getFurniture() {
        return furniture;
    }

    public void setFurniture(Boolean furniture) {
        this.furniture = furniture;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

}

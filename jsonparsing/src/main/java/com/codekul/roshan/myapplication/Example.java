
package com.codekul.roshan.myapplication;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("codekul")
    @Expose
    private String codekul;
    @SerializedName("course")
    @Expose
    private List<String> course = null;
    @SerializedName("infra")
    @Expose
    private Infra infra;
    @SerializedName("arrObj")
    @Expose
    private List<ArrObj> arrObj = null;

    public String getCodekul() {
        return codekul;
    }

    public void setCodekul(String codekul) {
        this.codekul = codekul;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public Infra getInfra() {
        return infra;
    }

    public void setInfra(Infra infra) {
        this.infra = infra;
    }

    public List<ArrObj> getArrObj() {
        return arrObj;
    }

    public void setArrObj(List<ArrObj> arrObj) {
        this.arrObj = arrObj;
    }

}

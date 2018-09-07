package com.pacot.myapplication;

public class Planets {
    private String name;
    private String diameter;
    private String status;
    private String imageFileName;

    public Planets(String name, String imageFileName, String diameter, String status) {
                this.name = name;
                this.diameter = diameter;
                this.status = status;
                this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public String getDiameter(){
        return diameter;
    }

    public String getStatus(){
        return status;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiameter(String diameter){
        this.diameter = diameter;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
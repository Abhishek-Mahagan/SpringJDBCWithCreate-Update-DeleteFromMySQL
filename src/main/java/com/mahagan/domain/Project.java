package com.mahagan.domain;

public class Project {
    private int ino;
    private String name;
    private String collage;
    private String city;
    private String state;

    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Project(int ino, String name, String collage, String city, String state) {
        this.ino = ino;
        this.name = name;
        this.collage = collage;
        this.city = city;
        this.state = state;

    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "ino=" + ino +
                ", name='" + name + '\'' +
                ", collage='" + collage + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

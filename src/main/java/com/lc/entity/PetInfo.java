package com.lc.entity;

public class PetInfo {
    private int petId; // 宠物编号

    private String petName; // 宠物名称

    private int petBreed; // 宠物品种编号

    private int petSex; // 宠物性别编号

    private String birthday; // 生日

    private String description; // 描述

    private String breed; // 种类

    private String sex; // 性别

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(int petBreed) {
        this.petBreed = petBreed;
    }

    public int getPetSex() {
        return petSex;
    }

    public void setPetSex(int petSex) {
        this.petSex = petSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void show(){
        System.out.println(petId + "\t" + petName + "\t" + breed + "\t" + sex + "\t" + birthday + "\t" + description);
    }
}

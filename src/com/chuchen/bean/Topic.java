package com.chuchen.bean;

public class Topic {
    private String id;
    private String name;
    private String teacherId;
    private short isChoose;
    private short isSubmit;
    private String grade;
    private double score;
    private String numberOne;
    private String numberTwo;
    private String numberThree;
    private String resFile;
    private String submitFile;
    private String introduction;

    public Topic() {
    }

    public Topic(String id, String name, String teacherId, String grade, String resFile, String introduction) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.grade = grade;
        this.resFile = resFile;
        this.introduction = introduction;
    }

    public Topic(String id, String name, String teacherId, short isChoose, short isSubmit, String grade, double score, String numberOne, String numberTwo, String numberThree, String resFile, String submitFile) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.isChoose = isChoose;
        this.isSubmit = isSubmit;
        this.grade = grade;
        this.score = score;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.resFile = resFile;
        this.submitFile = submitFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public short getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(short isChoose) {
        this.isChoose = isChoose;
    }

    public short getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(short isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(String numberThree) {
        this.numberThree = numberThree;
    }

    public String getResFile() {
        return resFile;
    }

    public void setResFile(String resFile) {
        this.resFile = resFile;
    }

    public String getSubmitFile() {
        return submitFile;
    }

    public void setSubmitFile(String submitFile) {
        this.submitFile = submitFile;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", isChoose=" + isChoose +
                ", isSubmit=" + isSubmit +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                ", numberOne='" + numberOne + '\'' +
                ", numberTwo='" + numberTwo + '\'' +
                ", numberThree='" + numberThree + '\'' +
                ", resFile='" + resFile + '\'' +
                ", submitFile='" + submitFile + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}

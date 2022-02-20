package com.chuchen.bean;

public class Student extends Person {
    private String password;
    private String phone;
    private String topicId;
    private double score;

    public Student() {
        super();
    }

    public Student(String id, String name, String gender, int age, String phone,String password) {
        super(id, name, gender, age);
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", phone='" + phone + '\'' +
                ", topicId='" + topicId + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

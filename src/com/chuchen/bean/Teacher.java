package com.chuchen.bean;

public class Teacher extends Person{
    private String password;
    private String phone;

    public Teacher() {
        super();
    }

    public Teacher(String id, String name, String gender, int age, String phone, String password) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

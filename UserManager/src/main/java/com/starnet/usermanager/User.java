package com.starnet.usermanager;

public class User {

    private int uid;
    private String uname;
    private String sex;
    private int age;
    private String phone;
    private String address;


    public User(int uid, String uname, String sex, int age, String phone, String address) {
        this.uid = uid;
        this.uname = uname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

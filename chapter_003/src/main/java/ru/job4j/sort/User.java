/*
 *  Created by NTolkachev on 05.03.2019.
 */
package ru.job4j.sort;

public class User implements Comparable<User> {

    Integer age;
    String name;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(this.age, user.age);
    }

    public Boolean equals (User user) {
        return (this.age.equals(user.age)) && (this.name.equals(user.name));
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

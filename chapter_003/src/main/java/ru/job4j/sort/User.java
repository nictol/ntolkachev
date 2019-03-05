/*
 *  Created by NTolkachev on 05.03.2019.
 */
package ru.job4j.sort;

public class User implements Comparable<User> {

    Integer age;
    String name;

    @Override
    public int compareTo(User o) {
        return 0;
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

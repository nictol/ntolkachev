package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for (Person user : persons) {
            if ((user.getName().contains(key) || (user.getAddress().contains(key)) || (user.getPhone().contains(key)) || (user.getSurname().contains(key)))) {
                result.add(user);
            }

        }
        return result;
    }
}
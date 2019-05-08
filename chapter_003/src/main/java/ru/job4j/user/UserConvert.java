/*
 *  Created by NTolkachev on 11.02.2019.
 */
package ru.job4j.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class UserConvert {
    public HashMap<Integer, User> process(List<User> userList) {
        HashMap<Integer, User> mapUsers = new HashMap<>();
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            mapUsers.put(user.getId(), user);
        }
        return mapUsers;
    }
}

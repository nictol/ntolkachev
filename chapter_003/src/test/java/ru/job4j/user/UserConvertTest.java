/*
 *  Created by NTolkachev on 11.02.2019.
 */
package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void convertUsersToMap() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "User01", "Vologda"));
        users.add(new User(2, "User02", "Petrazovodk"));
        HashMap<Integer, User> mapUsers = new HashMap<>();
        mapUsers.put(1, users.get(0));
        mapUsers.put(2, users.get(1));
        UserConvert userConverter = new UserConvert();
        Map<Integer, User> result = userConverter.process(users);
        assertThat(result, is(mapUsers));
    }
}

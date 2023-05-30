package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void function() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Ace", "kfrsfik!mfd", "acegavrilovski@example.com");
        users.add(user1);
        assertFalse(SILab2.function(user1, users));
        User user2 = new User("Ace", null, "acegavrilovski@example.com");
        users.add(user2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        User user3 = new User("Ace", "957 3849378", "acegmail.com");
        users.add(user3);
        assertFalse(SILab2.function(user3, users));
        User user4 = new User("Ace", "123", "ace@gmail.com");
        users.add(user4);
        assertFalse(SILab2.function(user4, users));
        User user5 = new User(null, "9573 849378", "acegavrilovski@example.com");
        assertFalse(SILab2.function(user5, users));
    }

    @Test
    void multipleConditionsTest(){
        List<User> users = new ArrayList<>();

        //test1
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test2
        User user2 = new User("Ace", null, "a@yahoo.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test3
        User user3 = new User("Ace", "12345", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test4
        User user4 = new User("Ace", "12345@.!A", "ace@gmail.com");
        assertTrue(SILab2.function(user4, users));
    }
}

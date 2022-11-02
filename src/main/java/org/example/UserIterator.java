package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class UserIterator<User> implements Iterator {
    //    public UserIterator(Object p0) {
//    }
    private final ArrayList<User> users;
    private int index = -1;

    public UserIterator(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean hasNext() {
        return ++index < users.size();
    }

    @Override
    public Object next() {
        return users.get(index);
    }

}

package org.ajeet.learnings.systemdesign.user;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InMemoryUserRepository implements UserRepository{
    private final Map<String, User> userData;

    public InMemoryUserRepository() {
        this.userData = new HashMap<>();
    }

    @Override
    public User findUserById(String userId) {
        Objects.requireNonNull(userId);

        return userData.get(userId);
    }

    @Override
    public Collection<User> listUsers() {
        return userData.values();
    }

    @Override
    public void close() throws IOException {
        userData.clear();
    }
}

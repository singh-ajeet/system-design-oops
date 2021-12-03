package org.ajeet.learnings.systemdesign.user;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

public interface UserRepository extends Closeable {
    public User findUserById(String userId);
    public Collection<User> listUsers();
}

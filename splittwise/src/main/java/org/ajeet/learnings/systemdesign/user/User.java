package org.ajeet.learnings.systemdesign.user;

import java.util.Objects;

public final class User {
    private final String name;
    private final String userId;
    private final String email;
    private final String mobileNumber;

    public User(String name, String userId, String email, String mobileNumber) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return name.equals(user.name) &&
                userId.equals(user.userId) &&
                email.equals(user.email) &&
                mobileNumber.equals(user.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userId, email, mobileNumber);
    }
}

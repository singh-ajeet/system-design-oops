package org.ajeet.learnings.systemdesign.lld.snakeladder.user;

import java.util.HashMap;
import java.util.Map;

public final class Profile {
    public static final Object DEFAULT_AVATAR = "DEFAULT_AVATAR_SYMBOL";
    private final String profileName;
    private final Object avatar;

    private final Map<String, String> properties;

    public Profile(String profileName, Object avatar) {
        this.profileName = profileName;
        this.avatar = avatar;
        this.properties = new HashMap<>();
    }

    public String getProfileName() {
        return profileName;
    }

    public Object getAvatar() {
        return avatar;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getProperty(String propertyName){
        return properties.get(propertyName);
    }
}

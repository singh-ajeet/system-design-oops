package org.ajeet.learnings.systemdesign.lld.snakeladder.user;

public class Player extends User {
    private final Profile profile;

    public Player(String name, String email, String phone, Profile profile) {
        super(name, email, phone);
        this.profile = profile;
    }

    public Player(String name, String email, String phone) {
        super(name, email, phone);
        this.profile = createDefaultProfile();
    }

    private Profile createDefaultProfile() {
        return new Profile(this.getName() + " profile", Profile.DEFAULT_AVATAR);
    }

    public Profile getProfile() {
        return profile;
    }
}

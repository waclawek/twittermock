package user;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="user")
@DynamicUpdate
public class User {

    @Id
    @Column(name="username", updatable = false, nullable = false, length = 45)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    // followers users who follow this user
    // mapowanie na followee ponieważ jest on obserwowany przez folowera
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "followee")
    private Set<Follow> followers;
    //followees users which current user follows
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "follower")
    private Set<Follow> followees;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Set<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Follow> followers) {
        this.followers = followers;
    }

    public Set<Follow> getFollowees() {
        return followees;
    }

    public void setFollowees(Set<Follow> followees) {
        this.followees = followees;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}

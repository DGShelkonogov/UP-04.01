package com.example.testcratorspring.user_group;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "UserGroups")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    @OneToOne
    @JoinColumn(name = "GroupId")
    private Group group;

    @Column(name = "IsAdmin")
    private boolean is_admin;

    public UserGroup() {
    }

    public UserGroup(User user, Group group, boolean is_admin) {
        this.user = user;
        this.group = group;
        this.is_admin = is_admin;
    }

    public void setId_user_group(Long id_user_group) {
        this.id = id_user_group;
    }


    public Long getId_user_group() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}

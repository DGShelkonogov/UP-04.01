package com.example.testcratorspring.group;
import com.example.testcratorspring.test.Test;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Password")
    private String password;
    @Column(name = "Security_status")
    private String security_status;
    @Column(name = "InvitationLink")
    private String invitationLink;


    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "GroupTest", joinColumns = @JoinColumn(name = "GroupsId"),
            inverseJoinColumns = @JoinColumn(name = "TestsId"))
    private Set<Test> tests = new HashSet<>();


    public Group(String name, String password, String security_status, String invitationLink) {
        this.name = name;
        this.password = password;
        this.security_status = security_status;
        this.invitationLink = invitationLink;
    }

    public Group() {
    }

    public void setId_group(Long id_group) {
        this.id = id_group;
    }

    public Long getId_group() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_group) {
        this.name = name_group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity_status() {
        return security_status;
    }

    public void setSecurity_status(String security_status) {
        this.security_status = security_status;
    }

    public String getInvitationLink() {
        return invitationLink;
    }

    public void setInvitationLink(String invitation_link) {
        this.invitationLink = invitation_link;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}

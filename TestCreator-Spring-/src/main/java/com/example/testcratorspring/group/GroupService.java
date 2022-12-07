package com.example.testcratorspring.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class GroupService {

    @Autowired
    @Qualifier("groupRepository")
    private GroupRepository groupRepository;

    public Iterable<Group> getAllGroup(){
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(String id){
        return groupRepository.findById(Long.parseLong(id));
    }

    public Long addGroup(Group group){
        group.setInvitationLink(UUID.randomUUID().toString());
        Group group2 = groupRepository.save(group);
        return group2.getId_group();
    }

    public Group getGroupByLink(String link){
        return groupRepository.findByInvitationLink(link);
    }

    public void updateGroup(String id, Group group){
        Group group1 = getGroup(id).get();
        group1.setName(group.getName());
        group1.setPassword(group.getPassword());
        group1.setInvitationLink(group.getInvitationLink());
        group1.setSecurity_status(group.getSecurity_status());
        group1.setTests(group.getTests());
        groupRepository.save(group1);
    }

    public void deleteGroup(String id){
        groupRepository.deleteById(Long.parseLong(id));
    }
}

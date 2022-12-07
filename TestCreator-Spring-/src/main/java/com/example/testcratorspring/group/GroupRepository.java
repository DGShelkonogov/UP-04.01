package com.example.testcratorspring.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {


     Group findByName(String pass);

     Group findByInvitationLink(String link);

}

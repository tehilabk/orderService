package com.consumerservice.reposirory;

import com.consumerservice.model.entity.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    List<UserModel> findAllByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);

}

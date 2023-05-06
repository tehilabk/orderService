package com.example.consumerservice.reposirory;

import com.example.consumerservice.model.entity.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    List<UserModel> findAllByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);

}

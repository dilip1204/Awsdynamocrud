package com.practise.aws.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.aws.model.UserDetails;

@Repository
@EnableScan
public interface UserCrudRepository extends CrudRepository<UserDetails, String> {

	List<UserDetails> findByLastName(String lastName);
}
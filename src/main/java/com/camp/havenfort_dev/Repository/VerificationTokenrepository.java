package com.camp.havenfort_dev.Repository;

import com.camp.havenfort_dev.entity.VerificationToken;
import org.springframework.data.repository.CrudRepository;



public interface VerificationTokenrepository extends CrudRepository<VerificationToken,Long>{
	VerificationToken findByToken(String token);
}

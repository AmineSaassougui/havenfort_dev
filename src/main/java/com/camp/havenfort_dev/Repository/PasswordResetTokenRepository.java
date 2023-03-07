package com.camp.havenfort_dev.Repository;

import com.camp.havenfort_dev.entity.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;


public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long> {
	PasswordResetToken findByToken(String token);
}

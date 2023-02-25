package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity,Long> {
}

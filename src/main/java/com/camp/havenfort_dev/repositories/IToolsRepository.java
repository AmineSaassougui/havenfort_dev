package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.Tools;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IToolsRepository extends CrudRepository<Tools, Long> {
    List<Tools> findToolsByShopId(Long shopId);
}

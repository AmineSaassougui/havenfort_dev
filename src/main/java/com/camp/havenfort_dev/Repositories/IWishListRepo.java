package com.camp.havenfort_dev.Repositories;

import com.camp.havenfort_dev.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWishListRepo extends JpaRepository<WishList,Long> {
}

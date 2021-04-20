package com.starnet.usermanager.repository;

import com.starnet.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUname(String uname);

    void deleteByUid(int uid);

    @Modifying
    @Transactional
    @Query("delete from user_info ui where ui.uid in (?1)")
    void delete(List<Integer> idList);

    User deleteByUidAndUname(Integer uid, String uname);

    List<User> findAll();

}

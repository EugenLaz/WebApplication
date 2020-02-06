package DAO.Repository;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("select b from Lesson b where b.date = :date and b.group=:grop")
    Object save(@Param("user") User user);

}

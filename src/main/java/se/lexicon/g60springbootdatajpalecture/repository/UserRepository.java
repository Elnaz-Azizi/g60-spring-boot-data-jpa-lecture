package se.lexicon.g60springbootdatajpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.g60springbootdatajpalecture.entity.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    //SELECT * FROM user WHERE email = ?
    Optional<User> findByEmail(String email);

    //SELECT * FROM user WHERE full_name LIKE %?%
    List<User> findByFullNameContaining(String name);

    // SELECT * FROM user WHERE create_date > ?
    List<User> findByCreateDateAfter(Instant date);

    //Native SQL
   /* @Query(value = "SELECT * FROM users WHERE full_name LIKE %:name%", nativeQuery = true)
    List<User> selectByFullNameContaining(@Param("name") String name);*/

    //JPQL
    @Query("SELECT u FROM User u WHERE u.fullName LIKE %:name%")
    List<User> selectByFullNameContaining(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.createDate > :date")
    List<User> selectByCreateDateAfter(@Param("date") Instant date);

    @Modifying
    @Query("UPDATE User u SET u.fullName = :name WHERE u.email = :email")
    int updateFullNameByEmail(@Param("name") String name,@Param("email") String email);
}

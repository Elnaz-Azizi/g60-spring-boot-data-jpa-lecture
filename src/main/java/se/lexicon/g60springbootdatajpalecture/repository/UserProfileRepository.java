package se.lexicon.g60springbootdatajpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g60springbootdatajpalecture.entity.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // SELECT * FROM user_profile WHERE nickname = ?
    Optional<UserProfile> findByNickname(String nickname);

    // SELECT * FROM user_profile WHERE address LIKE %?%
    List<UserProfile> findByAddressContaining(String address);
}

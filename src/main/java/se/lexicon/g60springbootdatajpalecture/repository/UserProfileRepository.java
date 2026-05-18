package se.lexicon.g60springbootdatajpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g60springbootdatajpalecture.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}

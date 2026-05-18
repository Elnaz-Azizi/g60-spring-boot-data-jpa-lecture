package se.lexicon.g60springbootdatajpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g60springbootdatajpalecture.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

package hu.demo.unidirectional.repositories;

import hu.demo.unidirectional.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User findOneByEmailAddress(String emailAddress);

}

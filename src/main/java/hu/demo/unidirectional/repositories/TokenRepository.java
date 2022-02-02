package hu.demo.unidirectional.repositories;

import hu.demo.unidirectional.entites.Token;
import hu.demo.unidirectional.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

  List<Token> findByUser(User user);

}

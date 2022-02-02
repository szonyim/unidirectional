package hu.demo.unidirectional.runner;

import hu.demo.unidirectional.entites.Token;
import hu.demo.unidirectional.entites.User;
import hu.demo.unidirectional.repositories.TokenRepository;
import hu.demo.unidirectional.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
public class RunDemo implements ApplicationListener<ContextRefreshedEvent> {

  private final UserRepository userRepository;
  private final TokenRepository tokenRepository;

  @Autowired
  public RunDemo(UserRepository userRepository, TokenRepository tokenRepository) {
    this.userRepository = userRepository;
    this.tokenRepository = tokenRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initDemoData();
    run();
  }

  @Transactional
  public void initDemoData() {
    User god = new User("God", "God", "god@heaven.hu");
    User adam = new User("First", "Adam", "adam@heaven.hu");
    User eve = new User("First", "Eve", "eve@heaven.hu");

    userRepository.saveAll(List.of(god, adam, eve));

    Token godHeavenAccessToken = new Token(UUID.randomUUID().toString(), god);
    Token godPurgatoryAccessToken = new Token(UUID.randomUUID().toString(), god);
    Token godHellAccessToken = new Token(UUID.randomUUID().toString(), god);

    Token adamHeavenAccessToken = new Token(UUID.randomUUID().toString(), adam);
    Token eveHeavenAccessToken = new Token(UUID.randomUUID().toString(), eve);

    tokenRepository.saveAll(List.of(
      godHeavenAccessToken,
      godPurgatoryAccessToken,
      godHellAccessToken,

      adamHeavenAccessToken,
      eveHeavenAccessToken
    ));
  }

  private void run() {
    List<User> users = userRepository.findAll();
    for (User user : users) {
      System.out.println("Current user: " + user.getFullName());

      List<Token> godTokens = tokenRepository.findByUser(user);
      for(Token token : godTokens) {
        System.out.println("Token: " + token.getAccessToken());
      }
      System.out.println("-----------------------------------------------------------");
    }

  }

}

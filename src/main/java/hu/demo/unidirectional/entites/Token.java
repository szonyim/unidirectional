package hu.demo.unidirectional.entites;

import javax.persistence.*;

@Entity
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String accessToken;

  @ManyToOne(optional = false)
  @JoinColumn(name="user_id")
  private User user;

  public Token() {
  }

  public Token(String accessToken, User user) {
    this.accessToken = accessToken;
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

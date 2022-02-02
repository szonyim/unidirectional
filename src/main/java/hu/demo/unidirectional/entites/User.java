package hu.demo.unidirectional.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String firstName;

  private String lastName;

  private String emailAddress;

  public User() {
  }

  public User(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  public String getFullName(){
    return firstName + " " + lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}

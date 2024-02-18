package Ecommerce.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Organization {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
  public List<Product> products;
}

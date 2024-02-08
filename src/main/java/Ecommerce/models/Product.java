package Ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Double price = 0.0;

  @Column(nullable = false)
  private String description = "";

  @ManyToOne
  @JoinColumn(name = "organization_id", nullable = false)
  private Organization organization;
}

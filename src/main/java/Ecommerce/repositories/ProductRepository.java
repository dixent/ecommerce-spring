package Ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByOrganizationIdAndId(Long organizationId, Long id);
    Iterable<Product> findAllByOrganizationId(Long organizationId);
}

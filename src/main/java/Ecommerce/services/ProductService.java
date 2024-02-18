package Ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecommerce.models.Organization;
import Ecommerce.models.Product;
import Ecommerce.repositories.OrganizationRepository;
import Ecommerce.repositories.ProductRepository;

@Service
public class ProductService implements Ecommerce.services.interfaces.ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrganizationRepository organizationRepository;

  public Product createProduct(Long organizationId, Product productData) {
    Optional<Organization> organization = organizationRepository.findById(organizationId);

    if (organization.isPresent()) {
      productData.setOrganization(organization.get());

      return productRepository.save(productData);
    } else {
      return null;
    }
  }

  public Product updateProduct(Long organizationId, Long productId, Product productData) {
    Optional<Product> optionalProduct = productRepository.findByOrganizationIdAndId(organizationId, productId);

    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();

      product.setPrice(productData.getPrice());
      product.setDescription(productData.getDescription());

      return productRepository.save(product);
    } else {
      return null;
    }
  }

  @SuppressWarnings("null")
  public void deleteProduct(Long organizationId, Long productId) {
    Optional<Product> optionalProduct = productRepository.findByOrganizationIdAndId(organizationId, productId);

    if (optionalProduct.isPresent()) {
      productRepository.delete(optionalProduct.get());
    }
  }
}

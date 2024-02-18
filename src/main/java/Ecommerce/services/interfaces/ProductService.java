package Ecommerce.services.interfaces;

import Ecommerce.models.Product;

public interface ProductService {
  Product createProduct(Long organizationId, Product productData);
  Product updateProduct(Long organizationId, Long productId, Product productData);
  void deleteProduct(Long organizationId, Long productId);
}

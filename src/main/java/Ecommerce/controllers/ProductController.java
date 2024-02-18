package Ecommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ecommerce.models.Product;
import Ecommerce.repositories.ProductRepository;
import Ecommerce.services.interfaces.ProductService;

@RestController
@RequestMapping("/api/organizations/{organizationId}/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductService productService;

  @PostMapping("")
  public ResponseEntity<Product> createProduct(
    @PathVariable("organizationId") Long organizationId,
    @RequestBody(required = true) Product productData) {

    Product product = productService.createProduct(organizationId, productData);

    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("")
  public ResponseEntity<Iterable<Product>> getAll(@PathVariable("organizationId") Long organizationId) {
    return new ResponseEntity<>(productRepository.findAllByOrganizationId(organizationId), HttpStatus.OK);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProduct(
    @PathVariable("organizationId") Long organizationId,
    @PathVariable("productId") Long productId
  ) {
    Optional<Product> product = productRepository.findByOrganizationIdAndId(organizationId, productId);

    if (product.isPresent()) {
      return new ResponseEntity<>(product.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(
    @PathVariable("organizationId") Long organizationId,
    @PathVariable("productId") Long productId,
    @RequestBody Product productData
  ) {

    Product product = productService.updateProduct(organizationId, productId, productData);

    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<HttpStatus> deleteProduct(
    @PathVariable("organizationId") Long organizationId,
    @PathVariable("productId") Long productId
  ) {
    productService.deleteProduct(organizationId, productId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

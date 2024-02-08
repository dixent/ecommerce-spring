package Ecommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ecommerce.models.Organization;
import Ecommerce.repositories.OrganizationRepository;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
  @Autowired
  private OrganizationRepository organizationRepository;

  @PostMapping("")
  public ResponseEntity<Organization> createOrganization(@RequestBody Organization organizationData) {
    try {
      return new ResponseEntity<>(organizationRepository.save(organizationData), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("")
  public ResponseEntity<Iterable<Organization>> getAll() {
    return new ResponseEntity<>(organizationRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{organizationId}")
  public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") Long organizationId) {
    @SuppressWarnings("null")
    Optional<Organization> organization = organizationRepository.findById(organizationId);

    if (organization.isPresent()) {
      return new ResponseEntity<>(organization.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{organizationId}")
  public ResponseEntity<Organization> updateOrganization(
    @PathVariable("organizationId") Long organizationId,
    @RequestBody Organization organizationData
  ) {
    @SuppressWarnings("null")
    Optional<Organization> organizationResult = organizationRepository.findById(organizationId);

    if (organizationResult.isPresent()) {
      Organization organization = organizationResult.get();
      organization.setName(organizationData.getName());

      return new ResponseEntity<>(organizationRepository.save(organization), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @SuppressWarnings("null")
  @DeleteMapping("/{organizationId}")
  public ResponseEntity<HttpStatus> deleteOrganization(@PathVariable("organizationId") Long organizationId) {
    try {
      organizationRepository.deleteById(organizationId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

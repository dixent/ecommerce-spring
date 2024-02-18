package Ecommerce;

import org.junit.jupiter.api.Test;

import Ecommerce.factories.OrganizationFactory;
import Ecommerce.models.Organization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class OrganizationTests {
  private Validator validator;

  @BeforeEach
  public void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
  }

  @Test
  public void testNameCannotBeBlank() {
      Organization org = OrganizationFactory.buildOrganization();
      org.setName("");

      Set<ConstraintViolation<Organization>> validations = validator.validate(org);
      assertFalse(validations.isEmpty());

      ConstraintViolation<Organization> validation = validations.iterator().next();
      assertEquals("Name is mandatory", validation.getMessage());
  }
}

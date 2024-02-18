package Ecommerce.factories;

import java.io.Console;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import Ecommerce.models.Organization;
import Ecommerce.repositories.OrganizationRepository;

public class OrganizationFactory {
    @Autowired
    private static OrganizationRepository organizationRepository;

    public static Organization buildOrganization() {
        return new Organization(
          String.format("TestOrganization#%1$s", UUID.randomUUID().toString())
        );
    }
    @SuppressWarnings("null")
    public static Organization createOrganization() {
        Organization organization = buildOrganization();
        organizationRepository.save(organization);
        return organization;
    }
}

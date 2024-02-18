package Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.models.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}

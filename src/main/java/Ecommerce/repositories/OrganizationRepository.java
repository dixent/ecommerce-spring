package Ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.models.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}

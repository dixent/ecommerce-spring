package Ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @PostMapping("/organizations")
    public String createOrganization(@RequestParam String name) {
        Organization org = new Organization();
        org.setName(name);

        organizationRepository.save(org);
        return "Saved";
    }

    @GetMapping("/organizations")
    public Iterable<Organization> index() {
        return organizationRepository.findAll();
    }
}

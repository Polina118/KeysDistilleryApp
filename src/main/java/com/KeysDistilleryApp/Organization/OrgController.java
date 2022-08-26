package com.KeysDistilleryApp.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/api/org")
public class OrgController {

    private final OrgRepository orgRepository;

    @Autowired
    public OrgController(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    @GetMapping
    public List<Organization> getOrganizations(){
        return orgRepository.findAll();
    }

    @GetMapping(path="response")
    public String usingHttpServletResponse(HttpServletResponse response) {
        response.addHeader("x-total-count", String.valueOf(orgRepository.findAll().size()));
        return String.valueOf(orgRepository.findAll().size());
    }

}


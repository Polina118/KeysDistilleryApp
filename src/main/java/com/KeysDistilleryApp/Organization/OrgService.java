package com.KeysDistilleryApp.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {

    OrgRepository Repository;

    @Autowired
    public OrgService(OrgRepository Repository) {
        this.Repository = Repository;
    }

    public List<Organization> getOrganizations(){
        return Repository.findAll();
    }
}

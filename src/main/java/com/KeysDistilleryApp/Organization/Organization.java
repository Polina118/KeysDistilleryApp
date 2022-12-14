package com.KeysDistilleryApp.Organization;

import javax.persistence.*;

@Table
@Entity
public class Organization {

    @Id
    @SequenceGenerator(
            name = "org_sequence",
            sequenceName = "org_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "org_sequence"
    )
    private Integer id;
    private String title;
    private String link;
    private String picture;

    public Organization(){}

    public Organization(String title, String link, String picture) {
        this.title = title;
        this.link = link;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getPicture() {
        return picture;
    }
}

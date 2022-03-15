package com.navrel.developerutility.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {

    private String name;
    private String catchPhrase;
    private String bs;

    public Company() {}
}
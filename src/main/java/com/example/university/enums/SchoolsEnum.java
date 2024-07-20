package com.example.university.enums;

import lombok.Getter;

@Getter
public enum SchoolsEnum {
    BAPA("Public and International Affairs"), BUSINESS("Business"), SITE ("School of IT and Engineering"), EDUCATION("School of Education"), LAW("School of Law");

    private final String fullName;
    SchoolsEnum(String fullName){
        this.fullName = fullName;
    }

}

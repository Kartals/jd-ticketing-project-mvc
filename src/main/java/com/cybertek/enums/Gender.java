package com.cybertek.enums;

public enum Gender {

    // MALE,FEMALE; ilk olarak bu şekilde yaoabiliriz

    // ikinci olarak aşağıdaki şekilde yapabiliriz

    MALE("Male"), FEMALE("Female");

    private final String value;

    private Gender(String value) {   // create contructor
        this.value=value;
    }

    public String getValue(){     // create getter
        return value;
    }
}

package com.cybertek.enums;

public enum Status {

    OPEN("Open"),IN_PROGRESS("In Progress"),UAT_Test("UAT Testing"), COMPLETE("completed");

    private final String value;

    private Status (String value){
        this.value=value;

    }
    public String getValue(){
        return value;
    }
}

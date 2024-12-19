package com.snsystems.model;

public class CompanyWrapper extends Company<PersonData> {

    public CompanyWrapper() {
    }

    public CompanyWrapper(String name, Team<PersonData> team) {
        super(name, team);
    }

}

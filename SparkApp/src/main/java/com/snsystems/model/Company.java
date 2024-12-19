package com.snsystems.model;

public class Company<T> {

    private String name;
    private Team<T> team;

    public Company() {
    }

    public Company(String name, Team<T> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team<T> getTeam() {
        return team;
    }

    public void setTeam(Team<T> team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}

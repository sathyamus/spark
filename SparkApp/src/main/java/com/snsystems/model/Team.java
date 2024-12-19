package com.snsystems.model;

public class Team<T> {

    public String name;
    public T person;

    public Team() {
    }

    public Team(String name, T person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPerson() {
        return person;
    }

    public void setPerson(T person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}

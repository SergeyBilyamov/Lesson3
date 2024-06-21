package com.genealogy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        if (person != null) {
            this.members.add(person);
        } else {
            throw new IllegalArgumentException("Member cannot be null");
        }
    }

    public Person findPersonByName(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getAllChildren(String personName) {
        Person person = findPersonByName(personName);
        if (person != null) {
            return person.getChildren();
        } else {
            return null;
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(Person::getBirthDate));
    }
}
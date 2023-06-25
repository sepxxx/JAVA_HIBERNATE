package org.example.test6ManyToManyPart1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="children")
public class Child {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="age")
    private int age;
    @Column(name="name")
    private String firstName;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name="child_section",
            joinColumns = @JoinColumn(name="child_id"),
            inverseJoinColumns = @JoinColumn(name="section_id")
    )
    private List<Section> sectionList;

    public Child() {
    }

    public Child(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public void addSectionToChild(Section s) {
        if(sectionList==null) {
            sectionList = new ArrayList<>();
        }
        sectionList.add(s);
    }
}

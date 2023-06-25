package org.example.test6ManyToManyPart1.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="section")
public class Section {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
   @JoinTable(
           name="child_section",
           joinColumns = @JoinColumn(name="section_id"),
           inverseJoinColumns = @JoinColumn(name="child_id")
    )
    List<Child> childList;


    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void addChildToSection(Child c) {
        if(childList==null) {
            childList = new ArrayList<>();
        }
        childList.add(c);
    }
}

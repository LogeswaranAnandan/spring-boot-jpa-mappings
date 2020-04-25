package io.ztech.mappingsdemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Speciality {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speciality [id=" + id + ", name=" + name + "]";
    }

}
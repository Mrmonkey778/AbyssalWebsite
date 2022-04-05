package com.example.demo.Content;

import javax.persistence.*;

@Entity
@Table

public class Content {

    @Id
    @SequenceGenerator(
            name = "content_sequence",
            sequenceName = "content_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "content_sequence"
    )

    private Long id;
    private String name, description;
    private Integer type;

    public Content(){

    }

    public Content( Long id, String name, String description, Integer type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Content(String name, String description, Integer type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Content{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}

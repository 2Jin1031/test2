package com.halo.eventer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;

    private String name;

    private String summary;

    private String location;

    private Boolean isOperation;

    private String operationHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Menu> menus = new ArrayList<>();

    public Store(String tag, String name, String summary, String location, Boolean isOperation, String operationHours, Festival festival) {
        this.tag = tag;
        this.name = name;
        this.summary = summary;
        this.location = location;
        this.isOperation = isOperation;
        this.operationHours = operationHours;
        this.festival = festival;
    }
}

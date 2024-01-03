package org.openapitools.persistance.entity;

import jakarta.persistence.*;

@Entity
public class Savedviewfilterrule {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private Integer ruleType;

    @Column
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saved_view_id", nullable = false)
    private Savedview savedView;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(final Integer ruleType) {
        this.ruleType = ruleType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Savedview getSavedView() {
        return savedView;
    }

    public void setSavedView(final Savedview savedView) {
        this.savedView = savedView;
    }


}

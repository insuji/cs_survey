package com.lipaco.domain.survey;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private int star;
    private String attitude;
    private String know;
    private String etc;
    private String comment;

    @Builder
    public Survey(String brand, int star, String attitude,
                  String know, String etc, String comment) {
        this.brand = brand;
        this.star = star;
        this.attitude = attitude;
        this.know = know;
        this.etc = etc;
        this.comment = comment;
    }
}

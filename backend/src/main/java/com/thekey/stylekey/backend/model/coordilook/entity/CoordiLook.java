package com.thekey.stylekey.backend.model.coordilook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thekey.stylekey.backend.model.base.BaseTimeEntity;
import com.thekey.stylekey.backend.model.item.entity.Item;
import com.thekey.stylekey.backend.model.stylepoint.entity.StylePoint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coordilook")
public class CoordiLook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordilook_id", nullable = false)
    private Long id;

    @Column(name = "coordilook_title", nullable = false)
    private String title;

    @Column(name = "coordilook_image", nullable = false)
    private String image;

    // CoordiLook : StylePoint (N : 1)
    // 다대일 양방향 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stylepoint_id")
    @JsonIgnore
    private StylePoint stylepoint;

    @OneToMany(mappedBy = "coordilook", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @Builder
    public CoordiLook(String title, String image, StylePoint stylepoint) {
        this.title = title;
        this.image = image;
        this.stylepoint = stylepoint;
    }

    public void update(String title, String image, StylePoint stylepoint) {
        this.title = title;
        this.image = image;
        this.stylepoint = stylepoint;
    }
}

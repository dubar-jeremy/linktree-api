package io.github.dubar_jeremy.linktree_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Page {
    @Id
    private UUID id;

    @Column
    private String title;

    @Column
    private String slug;

    @Column
    private String description;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> links = new ArrayList<>();
}

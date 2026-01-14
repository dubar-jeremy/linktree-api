package io.github.dubar_jeremy.linktree_api;

import io.github.dubar_jeremy.linktree_api.config.JpaConfig;
import io.github.dubar_jeremy.linktree_api.config.Link;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Page extends JpaConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column()
    private String title;

    @Column()
    private String slug;

    @Column()
    private String description;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> links = new ArrayList<>();
}

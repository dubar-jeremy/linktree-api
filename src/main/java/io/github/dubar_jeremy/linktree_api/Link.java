package io.github.dubar_jeremy.linktree_api;

import io.github.dubar_jeremy.linktree_api.config.JpaConfig;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Link extends JpaConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column()
    private String label;

    @Column()
    private String url;

    @Column()
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;
}

package io.github.dubar_jeremy.linktree_api.repository;

import io.github.dubar_jeremy.linktree_api.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<Link, UUID> {}

package io.github.dubar_jeremy.linktree_api.repository;

import io.github.dubar_jeremy.linktree_api.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PageRepository extends JpaRepository<Page, UUID> {}

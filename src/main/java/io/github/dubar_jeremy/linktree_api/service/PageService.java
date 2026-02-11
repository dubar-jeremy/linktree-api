package io.github.dubar_jeremy.linktree_api.service;

import io.github.dubar_jeremy.linktree_api.model.Page;
import io.github.dubar_jeremy.linktree_api.provider.SlugProvider;
import io.github.dubar_jeremy.linktree_api.provider.UuidProvider;
import io.github.dubar_jeremy.linktree_api.repository.PageRepository;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final UuidProvider uuidProvider;
    private final SlugProvider slugProvider;

    public PageService(PageRepository pageRepository, UuidProvider uuidProvider, SlugProvider slugProvider) {
        this.pageRepository = pageRepository;
        this.uuidProvider = uuidProvider;
        this.slugProvider = slugProvider;
    }

    public Page createPage(String title, String description) {
        Page page = new Page();
        page.setId(uuidProvider.generate());
        page.setTitle(title);
        page.setSlug(slugProvider.generate(title));
        page.setDescription(description);
        return pageRepository.save(page);
    }
}
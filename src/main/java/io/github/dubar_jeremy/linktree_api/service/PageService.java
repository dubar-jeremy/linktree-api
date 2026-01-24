package io.github.dubar_jeremy.linktree_api.service;

import io.github.dubar_jeremy.linktree_api.model.Page;
import io.github.dubar_jeremy.linktree_api.provider.UuidProvider;
import io.github.dubar_jeremy.linktree_api.repository.PageRepository;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final UuidProvider uuidProvider;

    public PageService(PageRepository pageRepository, UuidProvider uuidProvider) {
        this.pageRepository = pageRepository;
        this.uuidProvider = uuidProvider;
    }


    public Page createPage(String title, String description) {
        Page page = new Page();
        page.setId(uuidProvider.generate());
        page.setTitle(title);
        page.setDescription(description);
        page.setSlug(uuidProvider.generate().toString()); //  TO IMPLEMENT
        return pageRepository.save(page);
    }
}
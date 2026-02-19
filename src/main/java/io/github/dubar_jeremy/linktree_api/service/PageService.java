package io.github.dubar_jeremy.linktree_api.service;

import io.github.dubar_jeremy.linktree_api.exception.SlugAlreadyExistsException;
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

    /**
     * The method throws the exception and ask the method that calls this one to catch it and handle it (Controller).
     * Check in review session if this is the best way to handle this or if I should catch the exception here and return an error response.
     */
    public Page createPage(String title, String description) throws SlugAlreadyExistsException {
        Page page = new Page();
        page.setId(uuidProvider.generate());
        page.setTitle(title);
        page.setSlug(this.generateSlug(title));
        page.setDescription(description);
        return pageRepository.save(page);
    }

    /*
     * Here I throw the exception and ask the method that calls this one to catch it and handle it.
     */
    private String generateSlug(String title) throws SlugAlreadyExistsException {

        // that one throw a runtime exception. I let the framework handle it.
        String slug = slugProvider.generate(title);

        if (pageRepository.existsBySlug(slug)) {
            throw new SlugAlreadyExistsException(slug);
        }

        return slug;
    }
}
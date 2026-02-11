package io.github.dubar_jeremy.linktree_api.provider;

import io.github.dubar_jeremy.linktree_api.exception.SlugException;
import org.springframework.stereotype.Component;

@Component
public class SlugProvider {

    public String generate(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new SlugException("title is empty");
        }

        return title.toLowerCase()
                .replaceAll("\\s+", "-")
                .replaceAll("[^a-z0-9\\-]", "");
    }
}

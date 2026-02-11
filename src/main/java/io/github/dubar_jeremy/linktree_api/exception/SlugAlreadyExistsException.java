package io.github.dubar_jeremy.linktree_api.exception;

public class SlugAlreadyExistsException extends Exception {
    public SlugAlreadyExistsException(String slug) {
        super("Slug already exists: " + slug);
    }
}

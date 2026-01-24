package io.github.dubar_jeremy.linktree_api.provider;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidProvider {

    public UUID generate() {
        return UUID.randomUUID();
    }
}

package io.github.dubar_jeremy.linktree_api.service;

import io.github.dubar_jeremy.linktree_api.model.Page;
import io.github.dubar_jeremy.linktree_api.provider.SlugProvider;
import io.github.dubar_jeremy.linktree_api.provider.UuidProvider;
import io.github.dubar_jeremy.linktree_api.repository.PageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PageServiceTest {

    private static final String TEST_TITLE = "Mon titre";
    private static final String TEST_DESCRIPTION = "Ma description";

    @Mock
    private PageRepository pageRepository;

    @Mock
    private UuidProvider uuidProvider;

    @Mock
    private SlugProvider slugProvider;

    @InjectMocks
    private PageService pageService;

    private UUID testUuid;

    @BeforeEach
    void setUp() {
        testUuid = UUID.randomUUID();
    }

    @Test
    void createPage_shouldGenerateUuidAndSavePage() {
        // Arrange
        when(uuidProvider.generate()).thenReturn(testUuid);
        when(pageRepository.save(any(Page.class))).thenAnswer(i -> i.getArgument(0));

        // Act
        Page result = pageService.createPage(TEST_TITLE, TEST_DESCRIPTION);

        // Assert
        assertEquals(testUuid, result.getId());
        assertEquals(TEST_TITLE, result.getTitle());
        assertEquals(TEST_DESCRIPTION, result.getDescription());
        assertEquals(slugProvider.generate(TEST_TITLE), result.getSlug());
        verify(uuidProvider, times(1)).generate();
    }
}

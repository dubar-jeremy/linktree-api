package io.github.dubar_jeremy.linktree_api.controller;

import io.github.dubar_jeremy.linktree_api.dto.CreatePageDto;
import io.github.dubar_jeremy.linktree_api.exception.SlugAlreadyExistsException;
import io.github.dubar_jeremy.linktree_api.model.Page;
import io.github.dubar_jeremy.linktree_api.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @PostMapping()
    public ResponseEntity<?> createPage(@RequestBody CreatePageDto createPageDto) {

        /**
         * Here I have few options.
         * 1: I send the DTO as it is to the service and let the service extract the data it needs.
         * 2: I extract the data from the DTO in the controller and send only the data that the service needs
         */

        /**
         * Option 1 :
         *  pro : - I don't have to extract the data in the controller, I just send the DTO as it is to the service and let the service handle it.
         *  con : - The service will have to know about the DTO, which is not
         *
         *  Option 2 :
         *  pro : - The service will not have to know about the DTO, it will only receive the data it needs.
         *  con : - I have to extract the data in the controller, which is not a big deal but it adds some extra code in the controller.
         */


        /**
         * I would generally prefer option 2. This way the service is not coupled to the DTO and it only receives the data it needs.
         * The controller is responsible for handling the HTTP request and extracting the data from the request body, while the service is responsible for handling the business logic and creating the page.
         * This way we have a clear separation of concerns and we can easily change the DTO without affecting the service
         */


        /*
         * Here I catch the SlugAlreadyExistsException and return a 409 Conflict status code with the error message in the response body.
         * But In the next step I will create a global exception handler (@ControllerAdvice) to handle this exception and return a proper error response.
         */
        try {
            Page page = this.pageService.createPage(createPageDto.title(), createPageDto.description());
            return ResponseEntity.ok(page);
        } catch (SlugAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}

package io.github.dubar_jeremy.linktree_api;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;


public class MyArchitectureTest {

    private static final String PROJECT_PACKAGE = "io.github.dubar_jeremy.linktree_api";

    private static final JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(PROJECT_PACKAGE);

    @Test
    void packagesShouldBeFreeOfCycles() {
        slices()
                .matching("%s.(**)".formatted(PROJECT_PACKAGE))
                .should().beFreeOfCycles()
                .check(IMPORTED_CLASSES);
    }

    @Test
    public void service_package_should_only_contain_services() {
        classes()
                .that().resideInAPackage("..service..")
                .should().haveSimpleNameEndingWith("Service")
                .andShould().beAnnotatedWith(org.springframework.stereotype.Service.class)
                .check(IMPORTED_CLASSES);
    }

    @Test
    public void repository_package_should_only_contain_repositories() {
        classes()
                .that().resideInAPackage("..repository..")
                .should().haveSimpleNameEndingWith("Repository")
                .andShould().beAnnotatedWith(org.springframework.stereotype.Repository.class)
                .check(IMPORTED_CLASSES);

    }

    @Test
    public void model_package_should_only_contain_models() {
        classes()
                .that().resideInAPackage("..model..")
                .should().haveSimpleNameNotContaining("Model")
                .andShould().beAnnotatedWith(jakarta.persistence.Entity.class)
                .check(IMPORTED_CLASSES);
    }

    @Test
    public void model_package_should_not_contain_entity() {
        classes()
                .that().resideInAPackage("..model..")
                .should().haveSimpleNameNotContaining("Entity" +
                        "")
                .andShould().beAnnotatedWith(jakarta.persistence.Entity.class)
                .check(IMPORTED_CLASSES);
    }

}

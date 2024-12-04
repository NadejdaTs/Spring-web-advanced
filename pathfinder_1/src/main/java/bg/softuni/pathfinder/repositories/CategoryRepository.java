package bg.softuni.pathfinder.repositories;

import bg.softuni.pathfinder.models.Category;
import bg.softuni.pathfinder.models.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByNameIn(Set<CategoryName> categories);
}

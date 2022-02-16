package uz.elmurodov.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.project.Project;

/**
 * @author Amonov Bunyod, ср 16.02.2022 15:56 .
 */
public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
}

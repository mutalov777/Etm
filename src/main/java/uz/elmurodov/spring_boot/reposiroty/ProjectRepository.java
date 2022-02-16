package uz.elmurodov.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.entity.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository{
}

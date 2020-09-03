package com.projects.project_management.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projects.project_management.models.ProjectChanges;
import com.projects.project_management.models.Projects;

public interface ProjectsChangeRepository extends JpaRepository<ProjectChanges, Long> {
	List<ProjectChanges> findById(int id);

	@Query(value = "select * from projectsdb.project_changes "
			+ " join  projectsdb.projects  on projects.project_id=project_changes.projects_project_id  where project_changes.projects_project_id=? order by created_time DESC", nativeQuery = true)
	List<ProjectChanges> findAllProjectChnagesById(int id);
	
	@Modifying
	@Transactional
	@Query(value="delete from projectsdb.project_changes where projects_project_id=?", nativeQuery = true)
	void deleteAllWithQuery(int project_id);
}

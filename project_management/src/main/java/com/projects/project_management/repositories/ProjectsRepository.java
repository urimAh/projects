package com.projects.project_management.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projects.project_management.models.ProjectChanges;
import com.projects.project_management.models.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {

	@Query(value="select * from projectsdb.projects where title LIKE %:title%", nativeQuery = true)
	public Page<Projects> findByTitle(String title, Pageable pagingSort);



}
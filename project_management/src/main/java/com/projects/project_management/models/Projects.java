package com.projects.project_management.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Projects implements Serializable{
	@Id
	private int project_id;
	String title;
	String description;
	boolean staus;
	
	int user_creator_id;
	int last_user_modifier_id;
	
	@Column(name="creation_date")
	private Timestamp creation_date;

	@OneToMany(mappedBy = "projects", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<ProjectChanges> projectChange;
	
	

}

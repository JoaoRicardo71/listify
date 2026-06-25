package com.joaoricardo.listify.repository;

import com.joaoricardo.listify.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository
        extends JpaRepository<Group, Long> {
}
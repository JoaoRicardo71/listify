package com.joaoricardo.listify.service;

import com.joaoricardo.listify.dto.auth.group.CreateGroupRequest;
import com.joaoricardo.listify.entity.Group;
import com.joaoricardo.listify.entity.User;
import com.joaoricardo.listify.repository.GroupRepository;
import com.joaoricardo.listify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public Group createGroup(
            CreateGroupRequest request,
            Authentication authentication
    ) {

        String email = authentication.getName();

        User owner = userRepository.findByEmail(email)
                .orElseThrow();

        Group group = Group.builder()
                .name(request.getName())
                .description(request.getDescription())
                .color(request.getColor())
                .createdAt(LocalDateTime.now())
                .owner(owner)
                .build();

        return groupRepository.save(group);
    }
}
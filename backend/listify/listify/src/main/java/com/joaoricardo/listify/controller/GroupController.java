package com.joaoricardo.listify.controller;

import com.joaoricardo.listify.dto.auth.group.CreateGroupRequest;
import com.joaoricardo.listify.entity.Group;
import com.joaoricardo.listify.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor

public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public Group createGroup(
            @RequestBody CreateGroupRequest request,
            Authentication authentication
    ) {
        System.out.println("=== GROUP CONTROLLER ===");
        System.out.println(authentication);

        return groupService.createGroup(request, authentication);
    }
}
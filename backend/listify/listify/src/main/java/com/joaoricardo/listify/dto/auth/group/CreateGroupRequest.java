package com.joaoricardo.listify.dto.auth.group;

import lombok.Data;

@Data
public class CreateGroupRequest {

    private String name;
    private String description;
    private String color;
}
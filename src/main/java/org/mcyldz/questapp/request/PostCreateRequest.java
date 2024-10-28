package org.mcyldz.questapp.request;

import lombok.Data;

@Data
public class PostCreateRequest {

    private String title;
    private String text;

    private Integer userId;
}

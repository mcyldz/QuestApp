package org.mcyldz.questapp.request;

import lombok.Data;

@Data
public class CommentCreateRequest {

    private Integer postId;
    private Integer userId;
    private String text;
}
